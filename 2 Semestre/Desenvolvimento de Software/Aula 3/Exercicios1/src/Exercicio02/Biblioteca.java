package Exercicio02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros;

    public Biblioteca(){
        livros = new ArrayList<Livro>();

        carregarLivros();
    }

    public List<Livro> buscarTitulo(String titulo){
        return livros.stream()
                     .filter(livro -> livro.getTitulo().equals(titulo))
                     .toList();
    }

    public List<Livro> buscarAutor(String autor){
        return livros.stream()
                     .filter(livro -> livro.getAutor().equals(autor))
                     .toList();
    }

    public List<Livro> buscarAnoPublicaca(LocalDate anoPublicacao){
        return livros.stream()
                     .filter(livro -> livro.getAnoPublicacao() == anoPublicacao)
                     .toList();
    }

    public List<Livro> getLivros(){
        return livros;
    }

    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }

    private void carregarLivros(){        
        livros.add(new Livro("To Kill a Mockingbird", "Harper Lee", LocalDate.of(1980, 1, 1)));
        livros.add(new Livro("1984", "George Orwell", LocalDate.of(1949, 1, 1)));
        livros.add(new Livro("Pride and Prejudice", "Jane Austen", LocalDate.of(1813, 1, 1)));
        livros.add(new Livro("The Great Gatsby", "F. Scott Fitzgerald", LocalDate.of(1925, 1, 1)));
        livros.add(new Livro("Harry Potter and the Philosopher's Stone", "J.K. Rowling", LocalDate.of(1997,1, 1)));
    }
}
