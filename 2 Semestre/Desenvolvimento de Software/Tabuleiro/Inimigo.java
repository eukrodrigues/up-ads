public class Inimigo extends Personagem {

    public static final String cor = "\u001B[31m";

    public Inimigo(String representacao, int posicaoX, int posicaoY){
        super(representacao, posicaoX, posicaoY);
    }

    @Override
    public String getCor(){
        return cor;
    }
}
