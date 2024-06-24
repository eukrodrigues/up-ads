package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Treino {
    private Professor professor;
    private Date dataInicio;
    private int execucoesProgramadas;
    private List<ExercicioTreino> exercicios;

    public Treino(Professor professor, Date dataInicio, int execucoesProgramadas, List<ExercicioTreino> exercicios) {
        this.professor = professor;
        this.dataInicio = dataInicio;
        this.execucoesProgramadas = execucoesProgramadas;
        this.exercicios = exercicios;
    }
    public Treino(Professor professor, Date dataInicio, int execucoesProgramadas){
        this.professor = professor;
        this.dataInicio = dataInicio;
        this.execucoesProgramadas = execucoesProgramadas;
        this.exercicios = new ArrayList<>();
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    public Date getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    public int getExecucoesProgramadas() {
        return execucoesProgramadas;
    }
    public void setExecucoesProgramadas(int execucoesProgramadas) {
        this.execucoesProgramadas = execucoesProgramadas;
    }
    public List<ExercicioTreino> getExercicios() {
        return exercicios;
    }
    public void setExercicios(List<ExercicioTreino> exercicios) {
        this.exercicios = exercicios;
    }
    public void adicionarExercicio(ExercicioTreino exercicio){
        this.exercicios.add(exercicio);
    }
}
