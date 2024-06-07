public class VeiculoTerrestre extends Veiculo{
    private int numeroRodas;

    public VeiculoTerrestre(String modelo, int ano, String cor, boolean ligado, int numeroRodas) {
        super(modelo, ano, cor, ligado);
        this.numeroRodas = numeroRodas;
    }

    public int getNumeroRodas() {
        return numeroRodas;
    }

    public void setNumeroRodas(int numeroRodas) {
        this.numeroRodas = numeroRodas;
    }

}
