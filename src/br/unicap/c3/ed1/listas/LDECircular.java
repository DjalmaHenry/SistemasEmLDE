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
            ult.setProx(prim);
            prim.setAnt(ult);
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        } else { // lista não está vazia
            prim.setAnt(novo);
            novo.setProx(prim);
            prim = novo;
            ult.setProx(prim);
            prim.setAnt(ult);
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
            ult.setProx(prim);
            prim.setAnt(ult);
            qtd++;
            System.out.println("Inserção efetuada com sucesso!");
        } else { // lista não está vazia
            novo.setAnt(ult);
            ult.setProx(novo);
            ult = novo;
            ult.setProx(prim);
            prim.setAnt(ult);
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
            prim.setAnt(ult);
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
            ult.setProx(prim);
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
            for (int i = 0; i != qtd; i++) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
        }
    }

    public void concatenar(LDECircular L2) {
        if (L2.isEmpty()) {
            System.err.println("Erro, a segunda lista está vazia!!");
        } else {
            if (isEmpty()) {
                prim = L2.prim;
                ult = L2.ult;
                qtd = L2.qtd;
                L2.prim = null;
                L2.ult = null;
                L2.qtd = 0;
            } else {
                ult.setProx(L2.prim);
                L2.prim.setAnt(ult);
                L2.ult.setProx(prim);
                prim.setAnt(L2.ult);
                ult = L2.ult;
                qtd += L2.qtd;
                L2.prim = null;
                L2.ult = null;
                L2.qtd = 0;
            }
            System.out.println("Lista concatenada sucesso!");
        }
    }

    public LDECircular dividir() {
        LDECircular L2 = new LDECircular();
        LDENode<T> aux;
        int cont;
        if (isEmpty()) {
            System.err.println("Erro, lista vazia!!");
            return L2;
        } else if (qtd == 1) {
            System.err.println("Erro, para dividir a lista, deve haver mais de um valor nela.");
            return L2;
        } else {
            cont = (qtd / 2) + (qtd % 2);
            aux = prim;
            for (int i = 0; i != qtd; i++) {
                aux = aux.getProx();
            }
            L2.prim = aux;
            L2.ult = ult;
            ult = aux.getAnt();
            prim.setAnt(ult);
            ult.setProx(prim);
            L2.prim.setAnt(L2.ult);
            L2.ult.setProx(L2.prim);
            L2.qtd = qtd - cont;
            qtd = cont;
        }
        System.out.println("Lista dividida com sucesso!");
        return L2;
    }
}
