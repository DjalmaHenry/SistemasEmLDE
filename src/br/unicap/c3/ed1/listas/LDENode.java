// Classe LDENode
package br.unicap.c3.ed1.listas;

class LDENode<T extends Comparable<T>> { // esta classe tem visibilidade de pacote

    private T info;
    private LDENode<T> ant;
    private LDENode<T> prox;

    LDENode(T valor) {
        info = valor;
    }

    void setInfo(T valor) {
        info = valor;
    }

    T getInfo() {
        return info;
    }

    void setAnt(LDENode<T> novoAnt) {
        ant = novoAnt;
    }

    LDENode<T> getAnt() {
        return ant;
    }

    void setProx(LDENode<T> novoProx) {
        prox = novoProx;
    }

    LDENode<T> getProx() {
        return prox;
    }
}
