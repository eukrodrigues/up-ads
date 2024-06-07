package Exercicio04;

public class Jogador {
    private final String nome;
    private Double pontuacao;
    private Integer nivel;

    public Jogador(String nome){
        this.nome = nome;
        this.pontuacao = 0.0;
        this.nivel = 1;
    }

    public String getNome(){
        return this.nome;
    }

    public Double getPontuacao(){
        return this.pontuacao;
    }

    public Integer getNivel(){
        return this.nivel;
    }

    public void aumentarPontuacao(Double pontuacao){
        this.pontuacao += pontuacao;
    }

    public void aumentarNivel(){
        this.nivel += 1;
    }

    public void exibirInfo(){
        System.out.println("#########################");
        System.out.println("Jogador: " + this.nome);
        System.out.println("Pontuação: " + this.pontuacao);
        System.out.println("Nível: " + this.nivel);
    }

}
