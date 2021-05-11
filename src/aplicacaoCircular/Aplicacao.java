// Classe Aplicacao
package aplicacaoCircular;

import br.unicap.c3.ed1.listas.LDECircular;
import java.util.Scanner;

public class Aplicacao {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDECircular<Integer> lista = new LDECircular();
        LDECircular<Integer> lista2 = new LDECircular();
        int op, num;
        do {
            System.out.println("MENU:");
            System.out.println("1 - Adicionar um número no início da lista.");
            System.out.println("2 - Adicionar um número no final da lista.");
            System.out.println("3 - Remover um número do início da lista.");
            System.out.println("4 - Remover um número do final da lista.");
            System.out.println("5 - Exibir a primeira lista de números.");
            System.out.println("6 - Exibir a segunda lista de números.");
            System.out.println("7 - Dividir em duas listas.");
            System.out.println("8 - Juntar as duas listas.");
            System.out.println("0 - Sair do programa.");
            System.out.println("Informe a opção desejada: ");
            System.out.print("-> ");
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe um número inteiro:");
                    System.out.print("-> ");
                    num = in.nextInt();
                    lista.inserirValorInicio(num);
                    break;
                case 2:
                    System.out.println("Informe um número inteiro:");
                    System.out.print("-> ");
                    num = in.nextInt();
                    lista.inserirValorFinal(num);
                    break;
                case 3:
                    lista.RemValorInicio();
                    break;
                case 4:
                    lista.RemValorFinal();
                    break;
                case 5:
                    lista.exibirValores();
                    break;
                case 6:
                    lista2.exibirValores();
                    break;
                case 7:
                    lista2 = lista.dividir();
                    break;
                case 8:
                    lista.concatenar(lista2);
                    break;
                case 0:
                    System.out.println("Desenvolvido por Djalma Henrique.");
                    System.out.println("Finalizando programa.");
                    break;
                default:
                    System.err.println("Erro, opção inválida!");
                    break;
            }
        } while (op != 0);
    }
}
