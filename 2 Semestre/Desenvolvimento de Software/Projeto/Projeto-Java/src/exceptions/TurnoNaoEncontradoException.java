package exceptions;
public class TurnoNaoEncontradoException extends RuntimeException{
    public TurnoNaoEncontradoException(){
        super("Turno não encontrado!");
    }
}
