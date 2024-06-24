package controllers;
import java.util.ArrayList;
import java.util.List;

import entities.Exercicio;

public class ExercicioController {
    private List<Exercicio> exercicios;

    public ExercicioController(){
        exercicios = new ArrayList<>();
    }

    public void exibirExercicios(){
        for(int i = 0; i < exercicios.size(); i++){
            System.out.println("(" + i + ") - " + exercicios.get(i).getNome());
        }
    }

    public Exercicio getByIndex(int index){
        return exercicios.get(index);
    }

    public void adicionarExercicio(Exercicio exercicio){
        exercicios.add(exercicio);
    }
    
}
