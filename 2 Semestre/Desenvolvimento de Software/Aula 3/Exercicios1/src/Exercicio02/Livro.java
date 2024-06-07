package Exercicio02;

import java.time.LocalDate;

public class Livro {

    private final String titulo;
    private final String autor;
    private final LocalDate anoPublicacao;
    
    public Livro(String titulo, String autor, LocalDate anoPublicacao){
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public void exibirInfo(){
        System.out.println("##############################");
        System.out.println("Título do Livro: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de Publicação: " +  anoPublicacao.getYear());
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public LocalDate getAnoPublicacao(){
        return this.anoPublicacao;
    }
}
