import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aluno {
    private static final Double MEDIA = 6.0;
    private static final int QTDE_NOTAS = 5; 

    private final String matricula;
    private final String nome;
    private List<Double> notas;
    private Double mediaFinal;
    private Boolean isAprovado;
    
    public Aluno(String matricula, String nome){
        this.matricula = matricula;
        this.nome = nome;
        notas = new ArrayList<>();
    }

    public void calcularMediaFinalEDefinirAprovacao(){
        calcularMediaFinal();
        setStatusAprovacao();
    }

    private void calcularMediaFinal(){
        this.mediaFinal = notas.stream().reduce(0.0, (a, b) -> (a + b)) / notas.size();
    }

    private void setStatusAprovacao(){
        this.isAprovado = (this.mediaFinal >= MEDIA);
    }

    public Boolean addNota(Double nota){
        if(this.notas.size() < QTDE_NOTAS){
            if(nota >= 0 && nota <= 10){
                notas.add(nota);
                return true;
            } else {
                System.out.println("Nota inválida. Informe uma nota de 0 a 10.");
                return false;
            }
        } else {
            System.out.println("Aluno já possui todas as notas cadastradas!");
            return false;
        }
        
    }

    public void imprimirNotas(){
        System.out.println("*******************************");
        System.out.println("Matricula: " + this.matricula);
        System.out.println("Nome: " + this.nome);
        System.out.println("Aprovado: (" + (this.isAprovado ? "X" : " ") + ") Sim  (" + (this.isAprovado ? " " : "X") + ") Não" );
        
        for(int i = 0; i < notas.size(); i++)
            System.out.println("Nota " + (i + 1) + ": " + notas.get(i));

        System.out.println("Nota Final: " + mediaFinal);
        System.out.println("*******************************");
    }

    public static int getQtdeMaximaNota(){
        return QTDE_NOTAS;
    }

    public List<Double> getNotas(){
        return notas;
    }

}
