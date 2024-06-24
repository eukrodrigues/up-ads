package exceptions;

public class RegiaoNaoEncontradaException extends RuntimeException {
    public RegiaoNaoEncontradaException(){
        super("Região não encontrada.");
    }
}
