public class VeiculoAquatico extends Veiculo{
    private float comprimento;

    public VeiculoAquatico(String modelo, int ano, String cor, boolean ligado, float comprimento) {
        super(modelo, ano, cor, ligado);
        this.comprimento = comprimento;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    
}
