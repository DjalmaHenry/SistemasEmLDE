// Classe Pessoa
package aplicacao;

import br.unicap.c3.ed1.listas.LDESemRepetidos;

public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private String rg;

    public Pessoa(String nome, String rg) {
        this.nome = nome;
        this.rg = rg;
    }

    public Pessoa(String rg) {
        this.rg = rg;
    }

    private String getNome() {
        return this.nome;
    }

    private void setNome(String novoNome) {
        this.nome = novoNome;
    }

    private String getRG() {
        return this.rg;
    }

    public String toString() {
        return "Nome: " + this.getNome() + " RG: " + this.getRG();
    }

    public int compareTo(Pessoa pessoa) {
        int result;
        result = this.rg.compareTo(pessoa.rg);
        return result;
    }
}
