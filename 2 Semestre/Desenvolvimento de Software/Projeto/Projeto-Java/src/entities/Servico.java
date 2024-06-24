package entities;
import exceptions.ServicoInexistenteException;

public enum Servico {
    Musculacao(1), Spinning(2), Judo(3), Karate(4), MuayThai(5);

    private int idServico;

    private Servico(int idServico){
        this.idServico = idServico;
    }

    private int getIdServico(){
        return this.idServico;
    }

    public static Servico fromId(int idServico){
        for(Servico servico : Servico.values()){
            if(servico.getIdServico() == idServico){
                return servico;
            }
        }

        throw new ServicoInexistenteException();
    }
}
