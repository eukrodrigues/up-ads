package Exercicio08;

public enum StatusPedido {
    EM_PREPARACAO(true, "Em Preparação"), AGUARDANDO_ENTREGA(true, "Pizza Pronta/Aguardando Entrega"), EM_ROTA_DE_ENTREGA(true, "Em Rota de Entrega"), ENTREGUE(false, "Entregue"), CANCELADO(false, "Cancelado");

    private Boolean pedidoAberto;
    private String descricao;

    StatusPedido(Boolean pedidoAberto, String descricao){
        this.pedidoAberto = pedidoAberto;
        this.descricao = descricao;
    }

    public Boolean isAberto(){
        return this.pedidoAberto;
    }

    public String getDescricao(){
        return this.descricao;
    }
}
