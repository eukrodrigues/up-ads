public class Personagem {
    private String representacao;
    private int posicaoX;
    private int posicaoY;

    public Personagem(String representacao, int posicaoX, int posicaoY){
        this.representacao = representacao;
        this.posicaoX = posicaoX;
        this.posicaoY = posicaoY;
    }

    public String getRepresentacao(){
        return representacao;
    }

    public int getPosicaoX(){
        return posicaoX;
    }

    public int getPosicaoY(){
        return posicaoY;
    }

    public void moverParaCima(){
        posicaoY = posicaoY - 1;
    }

    public void moverParaBaixo(){
        posicaoY = posicaoY + 1;
    }

    public void moverParaDireita(){
        posicaoX = posicaoX + 1;
    }

    public void moverParaEsquerda(){
        posicaoX = posicaoX - 1;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Personagem){
            if (((Personagem)obj).getRepresentacao() == this.representacao) {
                return true;
            }
        }

        return false;
    }

    public String getCor(){
        return "\u001B[30m";
    }

}
