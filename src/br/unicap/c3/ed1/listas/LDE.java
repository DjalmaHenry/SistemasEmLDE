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
