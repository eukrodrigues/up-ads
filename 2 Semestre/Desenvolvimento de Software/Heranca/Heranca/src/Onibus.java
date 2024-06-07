public class Onibus extends VeiculoTerrestre{
    private int capacidadePassageiros;
    private int portasAcesso;
    private int numeroParadas;
    
    public Onibus(String modelo, int ano, String cor, boolean ligado, int numeroRodas, int capacidadePassageiros,
            int portasAcesso, int numeroParadas) {
        super(modelo, ano, cor, ligado, numeroRodas);
        this.capacidadePassageiros = capacidadePassageiros;
        this.portasAcesso = portasAcesso;
        this.numeroParadas = numeroParadas;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public int getPortasAcesso() {
        return portasAcesso;
    }

    public void setPortasAcesso(int portasAcesso) {
        this.portasAcesso = portasAcesso;
    }

    public int getNumeroParadas() {
        return numeroParadas;
    }

    public void setNumeroParadas(int numeroParadas) {
        this.numeroParadas = numeroParadas;
    }

    public void abrirPortaDianteira(){

    }

    public void anunciarParadaProxima(){
        
    }
}
