package exceptions;
public class AlunoNaoEncontradoException extends RuntimeException {
    public AlunoNaoEncontradoException(){
        super("Aluno não encontrado.");
    }
}
