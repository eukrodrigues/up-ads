package Exercicio04;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Colecao {
    List<Jogador> jogadores;
    Scanner scan;

    public Colecao(){
        jogadores = new ArrayList<>();
        scan = new Scanner(System.in);
        carregarJogadores();
    }

    public Colecao adicionarJogador(Jogador jogador){
        jogadores.add(jogador);

        return this;
    }

    public void aumentarPontuacao(String nome, Double pontuacao){
        Boolean jogadorEncontrado = false;

        for(Jogador jogador : jogadores){
            if (jogador.getNome().equals(nome)){
                jogador.aumentarPontuacao(pontuacao);
                System.out.println("Pontuação alterada com sucesso! Nova pontuação: " + jogador.getPontuacao());
                jogadorEncontrado = true;
            }
        }

        if (!jogadorEncontrado){
            System.out.println("Jogador não encontrado.");
        }
    }

    public void aumentarNivel(String nome){
        Boolean jogadorEncontrado = false;

        for(Jogador jogador : jogadores){
            if (jogador.getNome().equals(nome)){
                jogador.aumentarNivel();
                System.out.println("Nível alterado com sucesso! Novo nível: " + jogador.getNivel());
                jogadorEncontrado = true;
            }
        }

        if (!jogadorEncontrado){
            System.out.println("Jogador não encontrado.");
        }
    }

    public Optional<Jogador> getJogador(String nome){
        return jogadores.stream()
                        .filter(jogador -> jogador.getNome().equals(nome))
                        .findFirst();
    }

    private void carregarJogadores(){
        jogadores.add(new Jogador("Kelvin"));
    }

}
