// Classe LDESemRepetidosOrdenado
package br.unicap.c3.ed1.listas;

public class LDESemRepetidosOrdenado<T extends Comparable<T>> {

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

    public void inserirOrdenadoDecrescente(T valor) { // método de inserção ordenada
        LDENode<T> novo = new LDENode(valor);
        LDENode<T> atual;
        if (isEmpty()) { // inserir na lista vazia
            prim = novo;
            ult = novo;
            qtd = 1;
            System.out.println("Valor inserido com sucesso!");
        } else if (novo.getInfo().compareTo(prim.getInfo()) > 0) { // inserir no início da lista
            novo.setProx(prim);
            prim.setAnt(novo);
            prim = novo;
            qtd++;
            System.out.println("Valor inserido com sucesso!");
        } else if (novo.getInfo().compareTo(ult.getInfo()) < 0) { // inserir no final da lista
            ult.setProx(novo);
            novo.setAnt(ult);
            ult = novo;
            qtd++;
            System.out.println("Valor inserido com sucesso!");
        } else { // inserção no meio da lista
            atual = prim;
            while (atual != null) {
                if (novo.getInfo().compareTo(atual.getInfo()) == 0) {
                    System.err.println("Erro, valor repetido!");
                    return;
                } else if (novo.getInfo().compareTo(atual.getInfo()) > 0) { // inserir
                    atual.getAnt().setProx(novo);
                    novo.setAnt(atual.getAnt());
                    novo.setProx(atual);
                    atual.setAnt(novo);
                    qtd++;
                    System.out.println("Valor inserido com sucesso!");
                    return;
                } else {
                    atual = atual.getProx();
                }
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

    public void exibirValoresCrescente() {
        LDENode<T> aux;
        if (isEmpty()) {
            System.err.println("Erro, Lista vazia.");
        } else {
            aux = ult;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getAnt();
            }
        }
    }

    public void exibirValoresDecrescente() {
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

    public void exibirValor(T p) {
        LDENode<T> aux;
        if (qtd == 0) {
            System.out.println("Lista vazia!!");
        } else {
            aux = buscaProd(p);
            if (aux == null) {
                System.err.println("Valor não cadastrado!");
            } else {
                System.out.println(aux.getInfo());
            }
        }
    }
}