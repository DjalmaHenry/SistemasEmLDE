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
        } else {
            aux = buscaProd(valor);
            if (aux == null) {
                System.err.println("Erro, valor não encontrado!");
            } else if (qtd == 1) {
                prim = null;
                ult = null;
                qtd--;
                System.out.println("Remoção efetuada com sucesso!");
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
}
