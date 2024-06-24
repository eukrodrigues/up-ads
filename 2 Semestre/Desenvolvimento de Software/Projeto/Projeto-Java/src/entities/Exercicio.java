package entities;
import enums.Dificuldade;
import enums.RegiaoExercicio;

public class Exercicio {
    private String nome;
    private RegiaoExercicio regiao;
    private Dificuldade dificuldade;

    public Exercicio(String nome, RegiaoExercicio regiao, Dificuldade dificuldade) {
        this.nome = nome;
        this.regiao = regiao;
        this.dificuldade = dificuldade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public RegiaoExercicio getRegiao() {
        return regiao;
    }
    public void setRegiao(RegiaoExercicio regiao) {
        this.regiao = regiao;
    }
    public Dificuldade getDificuldade() {
        return dificuldade;
    }
    public void setDificuldade(Dificuldade dificuldade) {
        this.dificuldade = dificuldade;
    }
}
