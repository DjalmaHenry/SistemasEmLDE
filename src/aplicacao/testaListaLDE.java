package aplicacao;

import java.util.Scanner;
import br.unicap.c3.ed1.listas.LDE;

public class testaListaLDE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDE<Integer> listaInt = new LDE();
        int op, num;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe um número inteiro:");
                    System.out.print("-> ");
                    num = in.nextInt();
                    listaInt.inserirValorInicio(num);
                    break;
                case 2:
                    System.out.println("Informe um número inteiro:");
                    System.out.print("-> ");
                    num = in.nextInt();
                    listaInt.inserirValorFinal(num);
                    break;
                case 3:
                    listaInt.RemValorInicio();
                    break;
                case 4:
                    listaInt.RemValorFinal();
                    break;
                case 5:
                    listaInt.exibirValores();
                    break;
                case 0:
                    System.out.println("Adeus!");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("MENU:");
        System.out.println("1 - Inserir novo valor no início da lista.");
        System.out.println("2 - Inserir novo valor no final da lista.");
        System.out.println("3 - Remover o primeiro elemento da lista.");
        System.out.println("4 - Remover o último elemento da lista.");
        System.out.println("5 - Exibir a lista.");
        System.out.println("0 - Sair do programa.");
        System.out.println("Informe a opção desejada:");
        System.out.print("-> ");
    }
}
