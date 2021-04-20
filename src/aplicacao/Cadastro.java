// Classe Cadastro
package aplicacao;

import br.unicap.c3.ed1.listas.LDESemRepetidos;
import java.util.Scanner;

public class Cadastro {

    private LDESemRepetidos<Pessoa> pessoas;

    public Cadastro() {
        pessoas = new LDESemRepetidos();
    }

    public void cadastraPessoa(String rg) {
        Scanner in = new Scanner(System.in);
        String nome;
        int op;
        boolean achou;
        Pessoa pessA = new Pessoa(rg);
        achou = pessoas.buscaNum(pessA);
        if (achou) {
            System.err.println("Erro, RG já cadastrado!");
        } else {
            System.out.println("Informe o nome: ");
            System.out.print("-> ");
            nome = in.next();
            in.nextLine();
            Pessoa pessB = new Pessoa(nome, rg);
            pessoas.inserirValorFinal(pessB);
            do {
                System.out.println("Deseja concluir o cadastro?");
                System.out.println("1 - Concluir cadastro.");
                System.out.println("2 - Cancelar cadastro.");
                System.out.print("-> ");
                op = in.nextInt();
                switch (op) {
                    case 1:
                        System.out.println("Cadastro concluido com sucesso!");
                        break;
                    case 2:
                        cancelaCadastro();
                        System.out.println("Cadastro cancelado.");
                        break;
                    default:
                        System.err.println("Erro, informe uma opção válida.");
                        break;
                }
            } while (op != 1 && op != 2);
        }
    }

    public void cancelaCadastro() {
        pessoas.remValorFinal();
    }

    public void exibirCadastro() {
        pessoas.exibirValores();
    }

    public void verificaPessoa(String rg) {
        Pessoa pessoa = new Pessoa(rg);
        boolean achou = pessoas.buscaNum(pessoa);
        if (achou) {
            System.out.println("Essa pessoa está no prédio!");
        } else {
            System.out.println("Essa pessoa NÃO está no prédio!");
        }
    }

    public void verificaPredio() {
        int cont = pessoas.getQtd();
        if (pessoas.isEmpty()) {
            System.out.println("O prédio está vazio!");
        } else {
            System.out.println("Existem " + pessoas.getQtd() + " pessoa(s) no prédio!");
        }
    }

    public void removePessoa(String rg) {
        Pessoa pessoa = new Pessoa(rg);
        pessoas.remover(pessoa);
    }
}
