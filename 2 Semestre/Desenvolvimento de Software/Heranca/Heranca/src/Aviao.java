public class Aviao extends VeiculoAereo{
    private float envergaduraAsa;
    private String tipoCombustivel;

    public Aviao(String modelo, int ano, String cor, boolean ligado, int numeroMotores, float envergaduraAsa,
            String tipoCombustivel) {
        super(modelo, ano, cor, ligado, numeroMotores);
        this.envergaduraAsa = envergaduraAsa;
        this.tipoCombustivel = tipoCombustivel;
    }

    public float getEnvergaduraAsa() {
        return envergaduraAsa;
    }

    public void setEnvergaduraAsa(float envergaduraAsa) {
        this.envergaduraAsa = envergaduraAsa;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }
    
}
