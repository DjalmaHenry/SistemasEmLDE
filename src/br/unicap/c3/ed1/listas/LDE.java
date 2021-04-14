package br.unicap.c3.ed1.listas;

public class LDE<T extends Comparable<T>> {

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

    public void inserirValorFinal(T valor) {
        LDENode<T> novo;
        boolean achou;
        novo = new LDENode(valor);
        if (isEmpty()) { // lista está vazia
            prim = novo;
            ult = novo;
            qtd++;
        } else { // lista não está vazia
            novo.setAnt(ult);
            ult.setProx(novo);
            ult = novo;
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        }
    }
}
