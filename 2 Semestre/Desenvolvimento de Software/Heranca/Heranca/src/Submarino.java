public class Submarino extends VeiculoAquatico {
    private float profundidadeMaxima;

    public Submarino(String modelo, int ano, String cor, boolean ligado, float comprimento, float profundidadeMaxima) {
        super(modelo, ano, cor, ligado, comprimento);
        this.profundidadeMaxima = profundidadeMaxima;
    }

    public float getProfundidadeMaxima() {
        return profundidadeMaxima;
    }

    public void setProfundidadeMaxima(float profundidadeMaxima) {
        this.profundidadeMaxima = profundidadeMaxima;
    }

    
}
