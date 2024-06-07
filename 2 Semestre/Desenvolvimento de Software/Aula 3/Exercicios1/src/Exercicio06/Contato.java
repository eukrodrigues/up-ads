package Exercicio06;

public class Contato {
    private final String nome;
    private String telefone;

    public Contato(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public String toString(){
        return "Nome do Contato: " + this.nome + " - Telefone: " + this.telefone;
    }

}
