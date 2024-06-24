package enums;

import exceptions.DificuldadeNaoEncontradaException;

public enum Dificuldade {
    Facil(1), Medio(2), Dificil(3), Muito_Dificil(4);

    private int idDificuldade;

    private Dificuldade(int idDificuldade){
        this.idDificuldade = idDificuldade;
    }

    private int getIdDificuldade(){
        return this.idDificuldade;
    }

    public static Dificuldade fromId(int idDificuldade){
        for(Dificuldade dificuldade : Dificuldade.values()){
            if(dificuldade.getIdDificuldade() == idDificuldade){
                return dificuldade;
            }
        }

        throw new DificuldadeNaoEncontradaException();
    }
}
