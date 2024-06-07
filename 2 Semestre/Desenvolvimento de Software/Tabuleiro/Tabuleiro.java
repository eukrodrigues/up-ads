public class Tabuleiro {

    private int tamX;
    private int tamY;
    private Personagem[][] posicoes;

    public Tabuleiro(int tamX, int tamY){
        this.tamX = tamX;
        this.tamY = tamY;
        posicoes = new Personagem[tamX][tamY];
    }

    public void exibirTabuleiro(){
        for(int i = 0; i < tamY; i ++){
            for(int j = 0; j < tamX; j++){
                if(posicoes[j][i] == null){
                    System.out.print("[ . ]");
                } else {
                    System.out.print(posicoes[j][i].getCor() + "[ " + posicoes[j][i].getRepresentacao() + " ]" + "\u001B[0m");
                }
            }
            System.out.print("\n");
        }
    }

    public boolean adicionarPersonagem(Personagem personagem){
        if(posicoes[personagem.getPosicaoX()][personagem.getPosicaoX()] == null){
            posicoes[personagem.getPosicaoX()][personagem.getPosicaoX()] = personagem;
            return true;
        }
        
        return false;
    }

    public Personagem moverParaCima(Personagem personagem){
        if(personagem.getPosicaoY() - 1 >= 0 && personagem.equals(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()])){
            if(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY() - 1] == null){
                personagem.moverParaCima();
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()] = personagem;
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY() + 1] = null;
            }
        }

        return personagem;
    }

    public Personagem moverParaBaixo(Personagem personagem){
        if(personagem.getPosicaoY() + 1 < tamY && personagem.equals(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()])){
            if(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY() + 1] == null){
                personagem.moverParaBaixo();
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()] = personagem;
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY() - 1] = null;
            }
        }

        return personagem;
    }

    public Personagem moverParaEsquerda(Personagem personagem){
        if(personagem.getPosicaoX() - 1 >= 0 && personagem.equals(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()])){
            if(posicoes[personagem.getPosicaoX() - 1][personagem.getPosicaoY()] == null){
                personagem.moverParaEsquerda();
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()] = personagem;
                posicoes[personagem.getPosicaoX() + 1][personagem.getPosicaoY()] = null;
            }
        }

        return personagem;
    }

    public Personagem moverParaDireita(Personagem personagem){
        if(personagem.getPosicaoX() + 1 < tamX && personagem.equals(posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()])){
            if(posicoes[personagem.getPosicaoX() + 1][personagem.getPosicaoY()] == null){
                personagem.moverParaDireita();
                posicoes[personagem.getPosicaoX()][personagem.getPosicaoY()] = personagem;
                posicoes[personagem.getPosicaoX() - 1][personagem.getPosicaoY()] = null;
            }
        }

        return personagem;
    }
   
}