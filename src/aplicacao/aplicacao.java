// Classe aplicacao
package aplicacao;

import java.util.Scanner;
import br.unicap.c3.ed1.listas.LDE;

public class Aplicacao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();
        int op;
        String rg;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe o RG:");
                    System.out.print("-> ");
                    rg = in.next();
                    in.nextLine();
                    cadastro.cadastraPessoa(rg);
                    break;
                case 2:
                    cadastro.exibirCadastro();
                    break;
                case 3:
                    System.out.println("Informe o RG:");
                    System.out.print("-> ");
                    rg = in.next();
                    in.nextLine();
                    cadastro.verificaPessoa(rg);
                    break;
                case 4:
                    cadastro.verificaPredio();
                    break;
                case 5:
                    System.out.println("Informe o RG:");
                    System.out.print("-> ");
                    rg = in.next();
                    in.nextLine();
                    cadastro.removePessoa(rg);
                    break;
                case 0:
                    System.out.println("Adeus!");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("MENU:");
        System.out.println("1 - Cadastrar uma pessoa.");
        System.out.println("2 - Exibir todas pessoas cadastradas.");
        System.out.println("3 - Verificar se uma pessoa está no prédio.");
        System.out.println("4 - Verificar quantas pessoas estão no prédio.");
        System.out.println("5 - Remover cadastro de uma pessoa.");
        System.out.println("0 - Sair do programa.");
        System.out.println("Informe a opção desejada:");
        System.out.print("-> ");
    }
}
