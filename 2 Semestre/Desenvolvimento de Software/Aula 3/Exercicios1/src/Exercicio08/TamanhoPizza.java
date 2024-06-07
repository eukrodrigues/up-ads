package Exercicio08;

public enum TamanhoPizza {
    PEQUENA(4, "Pequena"), MEDIA(6, "Média"), GRANDE(8, "Grande"), FAMILIA(12, "Família");

    private int qtdePedacos;
    private String descricao;

    TamanhoPizza(int qtdePedacos, String descricao){
        this.qtdePedacos = qtdePedacos;
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
