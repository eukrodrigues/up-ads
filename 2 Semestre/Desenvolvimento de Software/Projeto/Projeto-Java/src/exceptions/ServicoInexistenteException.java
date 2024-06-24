package exceptions;
public class ServicoInexistenteException extends RuntimeException {
    public ServicoInexistenteException(){
        super("Serviço não encontrado.");
    }
}
