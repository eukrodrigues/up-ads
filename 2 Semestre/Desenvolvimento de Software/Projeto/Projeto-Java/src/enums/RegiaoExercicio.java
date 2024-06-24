package enums;

import exceptions.RegiaoNaoEncontradaException;

public enum RegiaoExercicio {
    Perna_Anterior(1), Perna_Posterior(2), Ombro(3), Biceps(4), Triceps(5), Panturrilha(6), Abdomen(7);

    private int idRegiao;

    private RegiaoExercicio(int idRegiao){
        this.idRegiao = idRegiao;
    }

    private int getIdRegiao(){
        return this.idRegiao;
    }

    public static RegiaoExercicio fromId(int idRegiao){
        for(RegiaoExercicio regiao : RegiaoExercicio.values()){
            if(regiao.getIdRegiao() == idRegiao){
                return regiao;
            }
        }

        throw new RegiaoNaoEncontradaException();
    }
}
