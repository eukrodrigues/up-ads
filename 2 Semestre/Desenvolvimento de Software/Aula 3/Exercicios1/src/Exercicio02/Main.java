package Exercicio02;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        int opcao;
        Biblioteca biblioteca = new Biblioteca();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Bem-vindo a sua biblioteca virtual!");

        do{
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Buscar Livro\n2 - Listar todos os livros\n3 - Cadastrar novo livro\n4 - Sair");
            
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                    buscarLivro(biblioteca, scan);
                    break;
                case 2:
                    listarLivros(biblioteca);
                    break;
                case 3:
                    biblioteca = cadastrarLivro(biblioteca, scan);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
                }
            
        } while(opcao != 4);

        scan.close();
    }

    private static void buscarLivro(Biblioteca biblioteca, Scanner scan){
        List<Livro> livros = new ArrayList<>(); 
        int opcao;

        System.out.println("1 - Buscar por Titulo\n2 - Buscar por Autor\n3 - Buscar por Ano de Publicação\n4 - Sair");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1:
                livros = buscarLivroPorTitulo(biblioteca, scan);
                break;
            case 2:
                livros = buscarLivroPorAutor(biblioteca, scan);
                break;
            case 3:
                buscarLivroPorAnoPublicacao(biblioteca, scan);
                break;
            case 4:
                break;
            default:
                System.out.println("Opção Inválida.");
                break;
        }

        if(livros != null && livros.size() > 0){
            System.out.println("Livros Encontrados: ");
            livros.forEach(livro -> livro.exibirInfo());
        } else {
            System.out.println("Nenhum livro encontrado.");
        }        
    }

    private static List<Livro> buscarLivroPorTitulo(Biblioteca biblioteca, Scanner scan){
        String filtroString;
        
        scan.nextLine();
        filtroString = getTexto("Digite o Livro a ser pesquisado", scan);
        return biblioteca.buscarTitulo(filtroString);
    }

    private static List<Livro> buscarLivroPorAutor(Biblioteca biblioteca, Scanner scan){
        String filtroString;
        
        scan.nextLine();
        filtroString = getTexto("Digite o Autor a ser pesquisado: ", scan);
        return biblioteca.buscarAutor(filtroString);
    }

    private static List<Livro> buscarLivroPorAnoPublicacao(Biblioteca biblioteca, Scanner scan){
        LocalDate filtroData;

        scan.nextLine();
        filtroData = getData("Digite o Ano de Publicação a ser pesquisado: ", scan);
        return biblioteca.buscarAnoPublicaca(filtroData);
    }

    private static void listarLivros(Biblioteca biblioteca){
        List<Livro> livros = biblioteca.getLivros();
        livros.forEach(livro -> livro.exibirInfo());
    }

    private static Biblioteca cadastrarLivro(Biblioteca biblioteca, Scanner scan){
        String titulo, autor;
        LocalDate dataPublicacao;
        
        scan.nextLine();
        titulo = getTexto("Digite o título do livro a ser cadastrado: ", scan);
        autor = getTexto("Digite o nome do autor do livro a ser cadastrado: ", scan);
        dataPublicacao = getData("Digite a data de publicação do livro a ser cadastrado: ", scan);

        biblioteca.adicionarLivro(new Livro(titulo, autor, dataPublicacao));
        System.out.println("Livro cadastrado com sucesso!");
        return biblioteca;
    }

    private static String getTexto(String mensagem, Scanner scan){
        String retorno;

        System.out.println(mensagem);
        retorno = scan.nextLine();

        return retorno;
    }

    private static LocalDate getData(String mensagem, Scanner scan){
        LocalDate retorno;

        System.out.println(mensagem);
        retorno = LocalDate.of(Integer.parseInt(scan.nextLine()), 1, 1);

        return retorno;
    }



}
