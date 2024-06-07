import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final int QTDE_ALUNOS = 5;

    public static void main(String[] args) throws Exception {

        List<Aluno> alunos = new ArrayList<Aluno>();
        for(int i = 0; i < QTDE_ALUNOS; i++){
            Aluno aluno = montaInformacoesAluno();
            aluno.calcularMediaFinalEDefinirAprovacao();

            alunos.add(aluno);
        }

        for (Aluno aluno : alunos) {
            aluno.imprimirNotas();
        }
    }

    public static Aluno montaInformacoesAluno(){
        String nome, matricula;
        InterfaceInput input = new InterfaceInput();

        nome = input.lerTexto("Digite o nome do aluno: ");
        matricula = input.lerTexto("Digite a matricula do aluno: ");

        return getNotas(new Aluno(matricula, nome));
    }

    public static Aluno getNotas(Aluno aluno){
        InterfaceInput input = new InterfaceInput();
        Boolean isNotaInvalida;
        for(int i = 0; i < Aluno.getQtdeMaximaNota(); i++){
            do{
                isNotaInvalida = !aluno.addNota(input.lerDouble("Digite a nota " + (i + 1) + ": "));
            } while(isNotaInvalida && aluno.getNotas().size() < Aluno.getQtdeMaximaNota());
        }

        return aluno;
    }
}
