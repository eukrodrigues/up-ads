package Exercicio08;

public class Pizza {
    private final String nome;
    private final String ingredientes;
    private final Double valor_P;
    private final Double valor_M;
    private final Double valor_G;
    private final Double valor_GG;

    public Pizza(String nome, String ingredientes, Double valor_P, Double valor_M, Double valor_G, Double valor_GG){
        this.nome = nome;
        this.ingredientes = ingredientes;
        this.valor_P = valor_P;
        this.valor_M = valor_M;
        this.valor_G = valor_G;
        this.valor_GG = valor_GG;
    }

    public String getNome(){
        return this.nome;
    }

    public String getIngredientes(){
        return this.ingredientes;
    }

    public Double getValorP(){
        return this.valor_P;
    }

    public Double getValorM(){
        return this.valor_M;
    }

    public Double getValorG(){
        return this.valor_G;
    }

    public Double getValorGG(){
        return this.valor_GG;
    }

    public String toString(){
        return "Nome: " + this.nome + " - Ingredientes: " + this.ingredientes + " - Valor P: R$" + this.valor_P + " - Valor M: R$" + this.valor_M + " - Valor G: R$" + this.valor_G + " - Valor GG: R$" + this.valor_GG;
    }
}
