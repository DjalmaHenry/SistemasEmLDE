// Classe LDESemRepetidos
package br.unicap.c3.ed1.listas;

public class LDESemRepetidos<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public boolean isEmpty() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getQtd() {
        return qtd;
    }

    public boolean buscaNum(T valor) { // Busca sequencial simples
        LDENode<T> aux;
        if (qtd == 0) { // lista vazia
            return false;
        } else {
            aux = prim;
            while (aux != null) {
                if (aux.getInfo().compareTo(valor) == 0) {
                    return true;
                } else {
                    aux = aux.getProx();
                }
            }
            return false;
        }
    }

    public void inserirValorFinal(T valor) {
        LDENode<T> novo = new LDENode(valor);
        boolean achou;
        if (isEmpty()) { // lista está vazia
            prim = novo;
            ult = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        } else { // lista não está vazia
            achou = this.buscaNum(valor);
            if (achou) { // achou!
                System.out.println("Valor repetido! Inserção não efetuada!");
            } else {  // não achou!!!
                novo.setAnt(ult);
                ult.setProx(novo);
                ult = novo;
                qtd++;
                System.out.println("Inserção efetuada com sucesso!");
            }
        }
    }

    public void remValorFinal() {
        if (isEmpty()) { // lista está vazia
            System.err.println("Erro, lista vázia.");
        } else if (qtd == 1) {
            prim = null;
            ult = null;
            qtd--;
            System.out.println("Remoção efetuada com sucesso!");
        } else { // lista não está vazia
            ult = ult.getAnt();
            ult.setProx(null);
            qtd--;
            System.out.println("Remoção efetuada com sucesso!");
        }
    }

    public void exibirValores() {
        LDENode<T> aux;
        if (isEmpty()) {
            System.err.println("Erro, Lista vazia.");
        } else {
            aux = prim;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void remover(T valor) {
        LDENode<T> aux;
        if (isEmpty()) { // lista está vazia
            System.err.println("Erro, lista vazia.");
        } else if (qtd == 1) {
            if (valor.compareTo(prim.getInfo()) == 0) {
                prim = null;
                ult = null;
                qtd--;
                System.out.println("Remoção efetuada com sucesso!");
            } else {
                System.err.println("Erro, valor não encontrado!");
            }
        } else {
            aux = buscaProd(valor);
            if (aux == null) {
                System.err.println("Erro, valor não encontrado!");
            } else if (prim == aux) {
                prim = prim.getProx();
                prim.setAnt(null);
                qtd--;
                System.out.println("Remoção efetuada com sucesso!");
            } else if (ult == aux) {
                ult = ult.getAnt();
                ult.setProx(null);
                qtd--;
                System.out.println("Remoção efetuada com sucesso!");
            } else { // lista não está vazia
                aux.getAnt().setProx(aux.getProx());
                aux.getProx().setAnt(aux.getAnt());
                qtd--;
                System.out.println("Remoção efetuada com sucesso!");
            }
        }
    }

    private LDENode<T> buscaProd(T p) { // Busca sequencial simples
        LDENode<T> aux;
        if (isEmpty()) { // lista vazia
            return null;
        } else {
            aux = prim;
            while (aux != null) {
                if (aux.getInfo().compareTo(p) == 0) {
                    return aux;
                }
                aux = aux.getProx();
            }
            return null;
        }
    }

    public void RemValorInicio() {
        if (isEmpty()) { // lista está vazia
            System.err.println("Erro, lista vázia.");
        } else if (qtd == 1) {
            prim = null;
            ult = null;
            qtd--;
        } else { // lista não está vazia
            prim = prim.getProx();
            prim.setAnt(null);
            qtd--;
        }
    }

    public void inserirOrdenado(T valor) { // método de inserção ordenada
        LDENode<T> novo = new LDENode(valor);
        LDENode<T> atual;
        if (isEmpty()) { // inserir na lista vazia
            prim = novo;
            ult = novo;
            qtd = 1;
        } else if (novo.getInfo().compareTo(prim.getInfo()) < 0) { // inserir no início da lista
            novo.setProx(prim);
            prim.setAnt(novo);
            prim = novo;
            qtd++;
        } else if (novo.getInfo().compareTo(ult.getInfo()) > 0) { // inserir no final da lista
            ult.setProx(novo);
            novo.setAnt(ult);
            ult = novo;
            qtd++;
        } else { // inserção no meio da lista
            atual = prim;
            while (atual != null) {
                if (novo.getInfo().compareTo(atual.getInfo()) < 0) { // inserir
                    atual.getAnt().setProx(novo);
                    novo.setAnt(atual.getAnt());
                    novo.setProx(atual);
                    atual.setAnt(novo);
                    qtd++;
                    return;
                } else {
                    atual = atual.getProx();
                }
            }
        }
    }

    public void inserirOrdenadoDecrescente(T valor) { // método de inserção ordenada
        LDENode<T> novo = new LDENode(valor);
        LDENode<T> atual;
        if (isEmpty()) { // inserir na lista vazia
            prim = novo;
            ult = novo;
            qtd = 1;
        } else if (novo.getInfo().compareTo(prim.getInfo()) > 0) { // inserir no início da lista
            novo.setProx(prim);
            prim.setAnt(novo);
            prim = novo;
            qtd++;
        } else if (novo.getInfo().compareTo(ult.getInfo()) < 0) { // inserir no final da lista
            ult.setProx(novo);
            novo.setAnt(ult);
            ult = novo;
            qtd++;
        } else { // inserção no meio da lista
            atual = prim;
            while (atual != null) {
                if (novo.getInfo().compareTo(atual.getInfo()) > 0) { // inserir
                    atual.getAnt().setProx(novo);
                    novo.setAnt(atual.getAnt());
                    novo.setProx(atual);
                    atual.setAnt(novo);
                    qtd++;
                    return;
                } else {
                    atual = atual.getProx();
                }
            }
        }
    }

    public LDESemRepetidos<T> ordenar() {
        LDESemRepetidos<T> novaLista = new LDESemRepetidos();
        LDENode<T> aux;
        while (!this.isEmpty()) {
            aux = prim;
            this.RemValorInicio();
            novaLista.inserirOrdenado(aux.getInfo());
        }
        System.out.println("Lista Ordenada com sucesso!");
        return novaLista;
    }

    public LDESemRepetidos<T> ordenarDecrescente() {
        LDESemRepetidos<T> novaLista = new LDESemRepetidos();
        LDENode<T> aux;
        while (!this.isEmpty()) {
            aux = prim;
            this.RemValorInicio();
            novaLista.inserirOrdenadoDecrescente(aux.getInfo());
        }
        System.out.println("Lista Ordenada com sucesso!");
        return novaLista;
    }
}
