public class Carro extends VeiculoTerrestre{
    private int numeroPortas;
    private String tipoTransmissao;
    private float capacidadePortaMalas;

    public Carro(String modelo, int ano, String cor, boolean ligado, int numeroRodas, int numeroPortas,
            String tipoTransmissao, float capacidadePortaMalas) {
        super(modelo, ano, cor, ligado, numeroRodas);
        this.numeroPortas = numeroPortas;
        this.tipoTransmissao = tipoTransmissao;
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public String getTipoTransmissao() {
        return tipoTransmissao;
    }

    public void setTipoTransmissao(String tipoTransmissao) {
        this.tipoTransmissao = tipoTransmissao;
    }

    public float getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(float capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }

    public void ligarFarolNeblina(){

    }

    public void abrirTetoSolar(){
        
    }
    
    
}
