package Exercicio08;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private List<PedidoPizza> pizzas;
    private String endereco;
    private StatusPedido status;

    public Pedido(List<PedidoPizza> pizzas, TamanhoPizza tamanho, String endereco){
        this.pizzas = pizzas;
        this.endereco = endereco;
        this.status = StatusPedido.EM_PREPARACAO;
    }

    public Pedido(){
        this.pizzas = new ArrayList<>();
        this.status = StatusPedido.EM_PREPARACAO;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Double getValorPedido(){
        return pizzas.stream()
                     .mapToDouble(pizza -> pizza.getValor())
                     .reduce(0, (a, b) -> a + b);
    }

    public List<PedidoPizza> getPizzas(){
        return this.pizzas;
    }

    public String getEndereco(){
        return this.endereco;
    }

    public StatusPedido getStatus(){
        return this.status;
    }

    public void adicionarPizza(PedidoPizza pizza){
        pizzas.add(pizza);
    }

    public void removerPizza(int index){
        pizzas.remove(index);
    }

    public void listarPizzas(){
        for (int i = 0; i < pizzas.size(); i++){
            System.out.println(pizzas.get(i).toString());
        }
    }

    public String toString(){
        return "Endereço: " + this.endereco + " - Valor: " + getValorPedido() + " - Status: " + this.status.getDescricao();
    }

    public void exibirDetalhes(){
        System.out.println("##############");
        System.out.println("Endereço: " + this.endereco);
        System.out.println("Status: " + this.status.getDescricao());
        System.out.println("Valor Total: R$" + getValorPedido());
        System.out.println("Pizzas: ");
        for (PedidoPizza pizza : this.pizzas) {
            System.out.println(pizza.toString());
        }
    }
}
