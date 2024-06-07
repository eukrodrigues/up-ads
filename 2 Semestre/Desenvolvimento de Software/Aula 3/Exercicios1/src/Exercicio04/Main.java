package Exercicio04;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Colecao colecao = new Colecao();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Digite uma das opções abaixo: ");
            System.out.println("1 - Cadastrar jogador\n2 - Aumentar Pontuação\n3 - Aumentar Nível\n4 - Consultar Informações\n5 - Sair");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    colecao = adicionarJogador(colecao, scan);
                    break;
                case 2:
                    colecao = aumentarPontuacao(colecao, scan);
                    break;
                case 3:
                    colecao = aumentarNivel(colecao, scan);
                    break;
                case 4:
                    consultarInformacoes(colecao, scan);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while(opcao != 5);

        scan.close();
    }

    private static Colecao adicionarJogador(Colecao colecao, Scanner scan){
        String nome;

        scan.nextLine();
        nome = getTexto("Digite o nome do jogador: ", scan);
        colecao.adicionarJogador(new Jogador(nome));

        return colecao;
    }

    private static Colecao aumentarPontuacao(Colecao colecao, Scanner scan){
        String nome;
        Double pontuacao;
        
        scan.nextLine();
        nome = getTexto("Digite o nome do jogador: ", scan);
        pontuacao = getDouble("Digite o valor da pontuação a ser incluída: ", scan);

        colecao.aumentarPontuacao(nome, pontuacao);
        return colecao;
    }

    private static Colecao aumentarNivel(Colecao colecao, Scanner scan){
        String nome;
        
        scan.nextLine();
        nome = getTexto("Digite o nome do jogador: ", scan);
        colecao.aumentarNivel(nome);
        return colecao;
    }

    private static void consultarInformacoes(Colecao colecao, Scanner scan){
        String nome;
        Optional<Jogador> jogador;

        scan.nextLine();
        nome = getTexto("Digite o nome do jogador: ", scan);
        jogador = colecao.getJogador(nome);

        if (jogador.isPresent()){
            jogador.get().exibirInfo();
        } else {
            System.out.println("Jogador não encontrado.");
        }
    }

    private static String getTexto(String mensagem, Scanner scan){
        String retorno;

        System.out.println(mensagem);
        retorno = scan.nextLine();

        return retorno;
    }

    private static Double getDouble(String mensagem, Scanner scan){
        Double retorno;

        System.out.println(mensagem);
        retorno = scan.nextDouble();

        return retorno;
    }
}
