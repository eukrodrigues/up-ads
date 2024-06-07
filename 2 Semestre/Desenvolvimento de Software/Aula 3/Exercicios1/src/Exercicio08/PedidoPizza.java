package Exercicio08;

public class PedidoPizza {
    private Pizza pizza;
    private TamanhoPizza tamanho;
    private int quantidade;

    public PedidoPizza(Pizza pizza, TamanhoPizza tamanho, int quantidade){
        this.pizza = pizza;
        this.tamanho = tamanho;
        setQuantidade(quantidade);
    }

    public Double getValor(){
        return TamanhoPizza.PEQUENA == this.tamanho ? (pizza.getValorP() * quantidade) : 
               TamanhoPizza.MEDIA   == this.tamanho ? (pizza.getValorM() * quantidade) : 
               TamanhoPizza.GRANDE  == this.tamanho ? (pizza.getValorG() * quantidade) :
                                                      (pizza.getValorGG() * quantidade);
    }

    public void setQuantidade(int quantidade){
        if(quantidade > 0){
            this.quantidade = quantidade;
        } else {
            this.quantidade = 1;
            System.out.println("Inserindo 1 quantidade de pizza ao pedido ao invés de " + quantidade + ", pois 1 é a quantidade mínima para este pedido.");
        }
    }

    public String toString(){
        return "Pizza: " + this.pizza.getNome() + " - Tamanho: " + this.tamanho.getDescricao() + " - Quantidade: " + this.quantidade;
    }
}
