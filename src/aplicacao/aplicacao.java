// Classe aplicacao
package aplicacao;

import java.util.Scanner;

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
                    System.out.println("Informe o RG:");
                    System.out.print("-> ");
                    rg = in.next();
                    in.nextLine();
                    cadastro.removePessoa(rg);
                    break;
                case 3:
                    cadastro.exibirCadastroCrescente();
                    break;
                case 4:
                    cadastro.exibirCadastroDecrescente();
                    break;
                case 5:
                    System.out.println("Informe o RG:");
                    System.out.print("-> ");
                    rg = in.next();
                    in.nextLine();
                    cadastro.exibirPessoa(rg);
                    break;
                case 0:
                    System.out.println("Adeus!");
                    break;
                default:
                    System.err.println("Erro, opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("MENU:");
        System.out.println("1 - Cadastrar uma pessoa.");
        System.out.println("2 - Remover uma pessoa.");
        System.out.println("3 - Exibir cadastro em ordem crescente.");
        System.out.println("4 - Exibir cadastro em ordem decrescente.");
        System.out.println("5 - Exibir informações de uma pessoa.");
        System.out.println("0 - Sair do programa.");
        System.out.println("Informe a opção desejada:");
        System.out.print("-> ");
    }
}
