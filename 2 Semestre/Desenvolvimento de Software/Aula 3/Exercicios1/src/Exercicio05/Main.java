package Exercicio05;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Colecao colecao = new Colecao();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Digite uma das opções abaixo: ");
            opcao = getInt("1 - Cadastrar Carro\n2 - Acelerar\n3 - Frear\n4 - Sair", scan);
            
            switch (opcao) {
                case 1:
                    colecao = adicionarCarro(colecao, scan);
                    break;
                case 2:
                    colecao = acelerarCarro(colecao, scan);
                    break;
                case 3:
                    colecao = frearCarro(colecao, scan);
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

    private static Colecao adicionarCarro(Colecao colecao, Scanner scan){
        String marca, modelo;
        int anoFabricacao;

        scan.nextLine();
        marca = getTexto("Digite a marca do carro: ", scan);
        modelo = getTexto("Digite o modelo do carro: ", scan);
        anoFabricacao = getInt("Digite o ano de fabricação: ", scan);

        return colecao.adicionarCarro(new Carro(marca, modelo, LocalDate.of(anoFabricacao, 1, 1)));
    }

    private static Colecao acelerarCarro(Colecao colecao, Scanner scan){
        int opcao;
        
        System.out.println("Digite o número do carro a acelerar: ");
        colecao.listarCarros();

        opcao = scan.nextInt();

        if(opcao >= 0 && opcao < colecao.getCarros().size()){
            colecao.acelerar(colecao.getCarros().get(opcao));
        }

        return colecao;
    }

    private static Colecao frearCarro(Colecao colecao, Scanner scan){
        int opcao;
        
        System.out.println("Digite o número do carro a acelerar: ");
        colecao.listarCarros();

        opcao = scan.nextInt();

        if(opcao >= 0 && opcao < colecao.getCarros().size()){
            colecao.frear(colecao.getCarros().get(opcao));
        }

        return colecao;
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

    private static int getInt(String mensagem, Scanner scan){
        int retorno;

        System.out.println(mensagem);
        retorno = scan.nextInt();

        return retorno;
    }
    
}
