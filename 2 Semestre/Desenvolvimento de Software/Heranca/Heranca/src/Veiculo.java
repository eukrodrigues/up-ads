public class Veiculo {
    private String modelo;
    private int ano;
    private String cor;
    private boolean ligado;

    public Veiculo(String modelo, int ano, String cor, boolean ligado) {
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.ligado = ligado;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getCor() {
        return cor;
    }
    public void setCor(String cor) {
        this.cor = cor;
    }
    public boolean isLigado() {
        return ligado;
    }
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    @Override
    public String toString(){
        return "Modelo: " + this.modelo + " - Ano: " + this.ano + " - Cor: " + this.cor + " - Ligado: " + this.ligado;
    }
}
