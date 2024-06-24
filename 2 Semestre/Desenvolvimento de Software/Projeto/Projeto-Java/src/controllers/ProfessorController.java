package controllers;
import java.util.ArrayList;
import java.util.List;

import entities.Professor;

public class ProfessorController {
    List<Professor> professores;

    public ProfessorController() {
        this.professores = new ArrayList<>();
    }

    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }

    public void removerProfessor(Professor professor){
        professores.remove(professor);
    }
    
    public Professor getProfessor(String codigoProfessor){
        for (Professor professor : professores) {
            if(professor.getCodigoProfessor().equals(codigoProfessor)){
                return professor;
            }
        }

        return null;
    }
}
