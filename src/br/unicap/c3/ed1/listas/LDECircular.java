// Classe LDE
package br.unicap.c3.ed1.listas;

public class LDECircular<T extends Comparable<T>> {

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

    public void inserirValorInicio(T valor) {
        LDENode<T> novo;
        novo = new LDENode(valor);
        if (isEmpty()) { // lista está vazia
            prim = novo;
            ult = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        } else { // lista não está vazia
            prim.setAnt(novo);
            novo.setProx(prim);
            prim = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        }
    }

    public void inserirValorFinal(T valor) {
        LDENode<T> novo;
        novo = new LDENode(valor);
        if (isEmpty()) { // lista está vazia
            prim = novo;
            ult = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        } else { // lista não está vazia
            novo.setAnt(ult);
            ult.setProx(novo);
            ult = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        }
    }

    public void RemValorInicio() {
        if (isEmpty()) { // lista está vazia
            System.err.println("Erro, lista vázia.");
        } else if (qtd == 1) {
            prim = null;
            ult = null;
            qtd--;
            System.out.println("Remoção efetuada com sucesso!");
        } else { // lista não está vazia
            prim = prim.getProx();
            prim.setAnt(null);
            qtd--;
            System.out.println("Remoção efetuada com sucesso!");
        }
    }

    public void RemValorFinal() {
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
            System.out.println("Lista vazia!!");
        } else {
            aux = prim;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }
}
