package Exercicio07;

public class Produto {
    private final String nome;
    private final String codUnico;
    private Double preco;
    private int quantidade;

    public Produto(String nome, String codUnico, Double preco, int quantidade){
        this.nome = nome;
        this.codUnico = codUnico;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCodigoUnico(){
        return this.codUnico;
    }

    public Double getPreco(){
        return this.preco;
    }

    public void setPreco(Double preco){
        this.preco = preco;
    }

    public int getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public Boolean remover(int quantidade){
        if(this.quantidade >= quantidade){
            this.quantidade -= quantidade;
            return true; 
        } else {
            return false;
        }
    }

    public void adicionar(int quantidade){
        this.quantidade += quantidade;
    }

    public String toString(){
        return "Código: " + this.codUnico + " - Nome: " + this.nome + " - Preço: " + this.preco + " - Quantidade: " + this.quantidade;
    }

}
