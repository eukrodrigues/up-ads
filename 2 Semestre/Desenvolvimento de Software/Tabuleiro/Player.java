/**
 * Player
 */
public class Player extends Personagem {

    public static final String cor = "\u001B[34m";

    public Player(String representacao, int posicaoX, int posicaoY){
        super(representacao, posicaoX, posicaoY);
    }

    @Override
    public String getCor(){
        return cor;
    }
}