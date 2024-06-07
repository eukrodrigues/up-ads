import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicios11mar {
    private final int NOTA_MINIMA = 6;
    private final int QTDE_NOTAS = 5;
    private final String STATUS_APROVADO = "Aprovado";
    private final String STATUS_REPROVADO = "Reprovado";
    private Scanner scan;

    public Exercicios11mar(){
        scan = new Scanner(System.in);
    }

    private void imprimirResultado(String matricula, String nome, Boolean aprovado, Double notaFinal){
        System.out.println("*******************************");
        System.out.println("Matricula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("Status: " + (aprovado ? "Aprovado" : "Reprovado"));
        System.out.println("Nota Final: " + notaFinal);
        System.out.println("*******************************");
    }

    private void imprimirResultado(List<List<String>> alunos){
        for (List<String> aluno : alunos) {
            System.out.println("*******************************");
            System.out.println("Matricula: " + aluno.get(0));
            System.out.println("Nome: " + aluno.get(1));
            System.out.println("Aprovado: (" + aluno.get(2) == STATUS_APROVADO ? "X" : " " + ") Sim  (" + aluno.get(2) == STATUS_REPROVADO ? "X" : " " + ") Não" );
            for(int i = 4; i < (QTDE_NOTAS + 4); i++)
                System.out.println("Nota (" + (i - 3) + "): " + aluno.get(i));
            System.out.println("Nota Final: " + aluno.get(3));
            System.out.println("*******************************");
        }
    }

    @Deprecated
    public void calcularNotaAluno(){
        String matricula = lerTexto("Digite a matrícula: ");
        String nome = lerTexto("Digite o nome do aluno: ");
        Double nota1 = lerDouble("Digite o valor da nota 1: ");
        Double nota2 = lerDouble("Digite o valor da nota 2: ");
        Double notaFinal = (nota1 + nota2) / 2;
        imprimirResultado(matricula, nome, notaFinal >= NOTA_MINIMA , notaFinal);
    }

    public void calcularNotaAlunos(){
        List<List<String>> alunos = new ArrayList<>();

        for(int i = 0; i < 5; i ++){
            System.out.println("---- Informações do Aluno Número " + (i + 1) + " -----");
            alunos.add(lerInformacoesAluno());
        }

        imprimirResultado(alunos);
    }

    private List<String> lerInformacoesAluno(){
        List<String> aluno = new ArrayList<>();
        List<Double> notas;

        aluno.add(lerTexto("Digite a matrícula: "));
        aluno.add(lerTexto("Digite o nome do aluno: "));

        notas = lerNotas(QTDE_NOTAS);
        scan.nextLine();

        Double notaFinal = notas.stream()
                                .reduce(0.0, (a, b) -> (a + b)) / notas.size();

        aluno.add(notaFinal >= NOTA_MINIMA ? STATUS_APROVADO : STATUS_REPROVADO);
        aluno.add(Double.toString(notaFinal));
        aluno.add(Double.toString(notas.get(0)));
        aluno.add(Double.toString(notas.get(1)));
        aluno.add(Double.toString(notas.get(2)));
        aluno.add(Double.toString(notas.get(3)));
        aluno.add(Double.toString(notas.get(4)));
                
        return aluno;
    }

    private List<Double> lerNotas(int qtdeNotas){
        List<Double> notas = new ArrayList<>();

        for(int i = 0; i < qtdeNotas; i++){
            Double nota;

            do {
                nota = lerDouble("Digite o valor da nota " + (i + 1) + ": ");
                if (nota < 0 || nota > 10)
                    System.out.println("Data inválida.");
            } while (nota < 0 || nota > 10);

            notas.add(nota);
        }

        return notas;
    }

    private String lerTexto(String frase){
        System.out.println(frase);
        return scan.nextLine();
    }

    private Double lerDouble(String frase){
        System.out.println(frase);
        return scan.nextDouble();
    }

}
