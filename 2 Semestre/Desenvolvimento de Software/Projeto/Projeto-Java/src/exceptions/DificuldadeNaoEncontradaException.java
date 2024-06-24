package exceptions;

public class DificuldadeNaoEncontradaException extends RuntimeException{
    public DificuldadeNaoEncontradaException(){
        super("Dificuldade não encontrada");
    }
}
