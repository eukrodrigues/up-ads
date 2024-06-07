public class VeiculoAereo extends Veiculo{
    private int numeroMotores;

    public VeiculoAereo(String modelo, int ano, String cor, boolean ligado, int numeroMotores) {
        super(modelo, ano, cor, ligado);
        this.numeroMotores = numeroMotores;
    }

    public int getNumeroMotores() {
        return numeroMotores;
    }

    public void setNumeroMotores(int numeroMotores) {
        this.numeroMotores = numeroMotores;
    }
}
