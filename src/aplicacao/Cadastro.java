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
        System.out.println("Informe o nome: ");
        System.out.print("-> ");
        nome = in.next();
        in.nextLine();
        Pessoa pessoa = new Pessoa(nome, rg);
        pessoas.inserirOrdenadoDecrescente(pessoa);
    }

    public void exibirCadastroCrescente() {
        pessoas.exibirValoresCrescente();
    }

    public void exibirCadastroDecrescente() {
        pessoas.exibirValoresDecrescente();
    }

    public void exibirPessoa(String rg) {
        Pessoa pessoa = new Pessoa(rg);
        pessoas.exibirValor(pessoa);
    }

    public void removePessoa(String rg) {
        Pessoa pessoa = new Pessoa(rg);
        pessoas.remover(pessoa);
    }
}
