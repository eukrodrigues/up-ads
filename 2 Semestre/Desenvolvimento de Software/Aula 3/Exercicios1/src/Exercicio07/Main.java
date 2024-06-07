package Exercicio07;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("Digite uma das opções abaixo: ");
            opcao = getInt("1 - Adicionar Produto\n2 - Remover Produto\n3 - Alterar Preço de Produto\n4 - Alterar Quantidade de Produto\n5 - Gerar Relatório de Produtos Disponíveis\n6 - Gerar Relatório de Quantidade Total de Produtos no Estoque\n7 - Gerar Relatório de Quantidade por Produto\n8 - Gerar Relatório de Valor Total em Estoque\n9 - Sair", scan);
            
            switch (opcao) {
                case 1:
                    produtos = adicionarProduto(produtos, scan);
                    break;
                case 2:
                    produtos = removerProduto(produtos, scan);
                    break;
                case 3:
                    produtos = alterarPreco(produtos, scan);
                    break;
                case 4:
                    produtos = alterarQuantidade(produtos, scan);
                    break;
                case 5:
                    gerarRelatorioProdutosDisponiveis(produtos);
                    break;
                case 6:
                    gerarRelatorioQuantidadeEstoque(produtos);
                    break;
                case 7:
                    gerarRelatorioQuantidadeEstoquePorProduto(produtos);
                    break;
                case 8:
                    gerarRelatorioValorTotalEmEstoque(produtos);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        }while(opcao != 9);

    }

    private static List<Produto> adicionarProduto(List<Produto> produtos, Scanner scan){
        String nome, codUnico;
        Double preco;
        int quantidade;

        scan.nextLine();
        nome = getTexto("Digite o nome do produto: ", scan);
        codUnico = getTexto("Digite o código do produto: ", scan);
        preco = getDouble("Digite o preço do produto: ", scan);
        quantidade = getInt("Digite a quantidade do produto: ", scan);

        produtos.add(new Produto(nome, codUnico, preco, quantidade));
        System.out.println("Produto adicionado com sucesso!");
        
        return produtos;
    }

    private static List<Produto> removerProduto(List<Produto> produtos, Scanner scan){
        String codUnico;
        Optional<Produto> busca;
        
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

        scan.nextLine();
        codUnico = getTexto("Digite o Código do Produto que deseja excluir: ", scan);

        busca = produtos.stream()
                        .filter(produto -> produto.getCodigoUnico().equals(codUnico))
                        .findFirst();

        if (busca.isPresent()){
            produtos.remove(busca.get());
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Código Único inválido.");
        }

        return produtos;
    }

    private static List<Produto> alterarPreco(List<Produto> produtos, Scanner scan){
        String codUnico;
        Boolean produtoEncontrado = false;
        Double preco;
        
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

        scan.nextLine();
        codUnico = getTexto("Digite o Código do Produto que deseja alterar o preço: ", scan);

        for (Produto produto : produtos) {
            if (produto.getCodigoUnico().equals(codUnico)){
                preco = getDouble("Digite o novo preço do produto: ", scan);
                produto.setPreco(preco);
                System.out.println("Preço alterado com sucesso!");
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado){
            System.out.println("Código do Produto inválido.");
        }

        return produtos;
    }

    private static List<Produto> alterarQuantidade(List<Produto> produtos, Scanner scan){
        String codUnico;
        Boolean produtoEncontrado = false;
        int quantidade;
        
        for (Produto produto : produtos) {
            System.out.println(produto.toString());
        }

        scan.nextLine();
        codUnico = getTexto("Digite o Código do Produto que deseja alterar o preço: ", scan);

        for (Produto produto : produtos) {
            if (produto.getCodigoUnico().equals(codUnico)){
                quantidade = getInt("Digite a nova quantidade do produto: ", scan);
                produto.setQuantidade(quantidade);
                System.out.println("Quantidade alterada com sucesso!");
                produtoEncontrado = true;
            }
        }

        if (!produtoEncontrado){
            System.out.println("Código do Produto inválido.");
        }

        return produtos;
    }

    public static void gerarRelatorioProdutosDisponiveis(List<Produto> produtos){
        List<Produto> produtosDisponiveis = produtos.stream()
                                                    .filter(produto -> produto.getQuantidade() > 0)
                                                    .toList();

        if(produtosDisponiveis != null && produtosDisponiveis.size() > 0){
            System.out.println("Produtos Disponíveis: ");
            for (Produto produto : produtosDisponiveis) {
                System.out.println(produto.toString());
            }
        }
    }

    public static void gerarRelatorioQuantidadeEstoque(List<Produto> produtos){
        int quantidade = produtos.stream()
                                 .mapToInt(produto -> produto.getQuantidade())
                                 .reduce(0, (a, b) -> a + b);

        System.out.println("Quantidade total de produtos em estoque: " + quantidade);
    }

    public static void gerarRelatorioQuantidadeEstoquePorProduto(List<Produto> produtos){
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + " - Estoque: " + produto.getQuantidade());
        }
    }

    public static void gerarRelatorioValorTotalEmEstoque(List<Produto> produtos){
        Double valor = produtos.stream()
                               .mapToDouble(produto -> (produto.getPreco() * produto.getQuantidade()))
                               .reduce(0, (a, b) -> a + b);
        
        System.out.println("Valor total em estoque: R$" + valor);
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

    private static Double getDouble(String mensagem, Scanner scan){
        Double retorno;

        System.out.println(mensagem);
        retorno = scan.nextDouble();

        return retorno;
    }
}
