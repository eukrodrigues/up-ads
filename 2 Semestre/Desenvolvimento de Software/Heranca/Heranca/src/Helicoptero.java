public class Helicoptero extends VeiculoAereo{
    private int numeroHelices;
    private float capacidadeCarga;

    public Helicoptero(String modelo, int ano, String cor, boolean ligado, int numeroMotores, int numeroHelices,
            float capacidadeCarga) {
        super(modelo, ano, cor, ligado, numeroMotores);
        this.numeroHelices = numeroHelices;
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getNumeroHelices() {
        return numeroHelices;
    }

    public void setNumeroHelices(int numeroHelices) {
        this.numeroHelices = numeroHelices;
    }

    public float getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(float capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
}
