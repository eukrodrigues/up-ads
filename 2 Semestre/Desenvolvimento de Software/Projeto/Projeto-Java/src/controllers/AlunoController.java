package controllers;
import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import entities.ExercicioTreino;
import entities.Treino;
import exceptions.AlunoNaoEncontradoException;

public class AlunoController {
    private List<Aluno> alunos;

    public AlunoController(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public AlunoController(){
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno){
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno){
        alunos.remove(aluno);
    }

    public void pagarMensalidade(String matricula){
        
        Aluno aluno = getAluno(matricula);
        
        aluno.pagarMensalidade();
    }

    public void atualizarTreino(String matricula, Treino treino){
        Aluno aluno = getAluno(matricula);

        aluno.adicionarTreino(treino);
    }

    private Aluno getAluno(String matricula){

        for (Aluno aluno : alunos) {
            if(aluno.getMatricula().equals(matricula)){
                return aluno;
            }
        }

        throw new AlunoNaoEncontradoException();
    }

    public void exibirTreino(String matricula){
        Aluno aluno = getAluno(matricula);

        for (ExercicioTreino exercicio : aluno.getTreinoAtual().getExercicios()) {
            System.out.println(exercicio);
        }
    }
}
