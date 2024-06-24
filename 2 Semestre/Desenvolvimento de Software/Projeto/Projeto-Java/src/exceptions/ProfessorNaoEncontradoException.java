package exceptions;
public class ProfessorNaoEncontradoException extends RuntimeException {
    public ProfessorNaoEncontradoException(){
        super("Não foi encontrado nenhum professor com a matricula informada.");
    }
}
