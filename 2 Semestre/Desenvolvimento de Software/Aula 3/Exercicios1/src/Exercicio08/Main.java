package Exercicio08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("#################");
            System.out.println("      Menu");
            System.out.println("#################");

            do {
                opcao = getInt("1 - Detalhe de Pedido\n2 - Criar Pedido\n3 - Numero Total de Pedidos\n4 - Média de Valor dos Pedidos\n5 - Visualizar pedidos em aberto", scan);
                
                if(opcao < 1 || opcao > 5){
                    System.out.println("Opção inválida.");
                }

            }while(opcao < 1 || opcao > 5);

            switch (opcao) {
                case 1:
                    detalharPedido(pedidos, scan);
                    break;
                case 2:
                    pedidos = criarPedido(pedidos, scan);
                    break;
                case 3:
                    System.out.println("Número total de pedidos: " + pedidos.size());
                    break;
                case 4:
                    Double valorTotal = pedidos.stream()
                                               .mapToDouble(pedido -> pedido.getValorPedido())
                                               .reduce(0, (a, b) -> a + b);

                    System.out.println("Valor Médio dos Pedidos: " + (valorTotal / pedidos.size()));
                    break;
                case 5:
                    visualizarPedidosEmAberto(pedidos);
                    break;
                default:
                    break;
            }
        } while(true);

    }

    private static void visualizarPedidosEmAberto(List<Pedido> pedidos){
        if(pedidos.size() > 0){
            System.out.println("\n\n\n");
            System.out.println("#################");
            System.out.println("Pedidos Em Aberto");
            System.out.println("#################");
            for (Pedido pedido : pedidos) {
                if(pedido.getStatus().isAberto()){
                    System.out.println(pedido.toString());
                }
            }
        } else {
            System.out.println("Nenhum pedido em aberto");
        }
    }

    private static void detalharPedido(List<Pedido> pedidos, Scanner scan){
        if(pedidos.size() > 0){
            System.out.println(" PEDIDOS ");
            for (int i = 0; i < pedidos.size(); i++) {
                System.out.println(i + " - " + pedidos.get(i).toString());
            }

            int opcao = getInt("Digite o número do pedido que deseja visualizar os detalhes: ", scan);
            
            if (opcao >= 0 && opcao < pedidos.size()) {
                pedidos.get(opcao).exibirDetalhes();
            }
        } else {
            System.out.println("Nenhum pedido encontrado.");
        }
    }

    private static List<Pedido> criarPedido(List<Pedido> pedidos, Scanner scan){
        Pedido pedido = new Pedido();
        int opcao;

        scan.nextLine();
        pedido.setEndereco(getTexto("Digite o endereço do pedido: ", scan));
        do 
        {
            System.out.println("Digite a opção desejada: ");
            opcao = getInt("1 - Adicionar Pizza\n2 - Fechar Pedido", scan);

            if(opcao == 1){
                pedido.adicionarPizza(adicionarPizza(scan));
            } else if(opcao == 2){
                System.out.println("###############");
                System.out.println("DETALHES DO PEDIDO");
                pedido.exibirDetalhes();
                
                do {
                    opcao = getInt("1 - Continuar Editando\n2 - Concluir", scan);
                    if(opcao < 1 || opcao > 2){
                        System.out.println("Opção inválida.");
                    }
                }while(opcao < 1 || opcao > 2);
            }

        }while(opcao != 2);

        pedidos.add(pedido);
        return pedidos;
    }
    
    private static PedidoPizza adicionarPizza(Scanner scan){
        Pizza pizza;
        TamanhoPizza tamanho;
        int quantidade;

        pizza = escolherPizza(scan);
        tamanho = escolherTamanhoPizza(scan);
        quantidade = getInt("Escolha a quantidade: ", scan);

        return new PedidoPizza(pizza, tamanho, quantidade);
    }

    private static Pizza escolherPizza(Scanner scan){
        List<Pizza> cardapio = carregarCardapio();
        int opcao;

        System.out.println("#############");
        System.out.println("  CARDÁPIO");
        System.out.println("#############");
        
        for(int i = 0; i < cardapio.size(); i++){
            System.out.println(i + " - " + cardapio.get(i).toString());
        }

        do {
            opcao = getInt("Digite o número da pizza que gostaria de adicionar", scan);
            if(opcao < 0 || opcao >= cardapio.size()){
                System.out.println("Número inválido.");
            }
        }while(opcao < 0 || opcao >= cardapio.size());

        return cardapio.get(opcao);
    }

    private static List<Pizza> carregarCardapio(){
        List<Pizza> cardapio = new ArrayList<>();
        cardapio.add(new Pizza("Portuguesa", "Molho de tomate, azeitona, presunto, queijo mussarela", 30.00, 50.00, 60.00, 70.00));
        cardapio.add(new Pizza("Marguerita", "Molho de tomate, queijo mussarela, manjericão", 35.00, 55.00, 65.00, 75.00));
        cardapio.add(new Pizza("Calabresa", "Molho de tomate, calabresa, cebola, queijo mussarela", 32.00, 52.00, 62.00, 72.00));
        cardapio.add(new Pizza("Frango com Catupiry", "Molho de tomate, frango desfiado, catupiry, queijo mussarela", 38.00, 58.00, 68.00, 78.00));
        cardapio.add(new Pizza("Quatro Queijos", "Molho de tomate, queijo mussarela, queijo prato, queijo cheddar, queijo parmesão", 40.00, 60.00, 70.00, 80.00));

        return cardapio;
    }

    private static String getTexto(String mensagem, Scanner scan){
        String retorno;

        System.out.println(mensagem);
        retorno = scan.nextLine();

        return retorno;
    }

    private static int getInt(String mensagem, Scanner scan){
        int retorno;

        System.out.println(mensagem);
        retorno = scan.nextInt();

        return retorno;
    }

    private static TamanhoPizza escolherTamanhoPizza(Scanner scan){
        int opcao;
        TamanhoPizza tamanho;

        System.out.println("#############");
        System.out.println("  TAMANHOS");
        System.out.println("#############");

        System.out.println("0 - " + TamanhoPizza.PEQUENA.getDescricao());
        System.out.println("1 - " + TamanhoPizza.MEDIA.getDescricao());
        System.out.println("2 - " + TamanhoPizza.GRANDE.getDescricao());
        System.out.println("3 - " + TamanhoPizza.FAMILIA.getDescricao());

        do {
            opcao = getInt("Digite o número do tamanho da pizza: ", scan);

            if(opcao < 0 || opcao > 3){
                System.out.println("Número inválido.");
            }
        } while(opcao < 0 || opcao > 3);

        switch (opcao) {
            case 0:
                tamanho = TamanhoPizza.PEQUENA;
                break;
            case 1:
                tamanho = TamanhoPizza.MEDIA;
                break;
            case 2:
                tamanho = TamanhoPizza.GRANDE;
                break;
            case 3:
                tamanho = TamanhoPizza.FAMILIA;
                break;
            default:
                tamanho = TamanhoPizza.PEQUENA;
                break;
        }

        return tamanho;
    }
}