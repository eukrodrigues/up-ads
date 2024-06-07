package Exercicio05;

import java.time.LocalDate;

public class Carro {
    private final String marca;
    private final String modelo;
    private final LocalDate anoFabricacao;
    private Double velocidadeAtual;

    private final Double CONST_AUMENTO_VELOCIDADE = 5.0;
    private final Double CONST_DIMINUICAO_VELOCIDADE = 5.0;

    public Carro(String marca, String modelo, LocalDate anoFabricacao){
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.velocidadeAtual = 0.0;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModelo(){
        return this.modelo;
    }

    public int getAnoFabricacao(){
        return this.anoFabricacao.getYear();
    }

    public Double getVelocidadeAtual(){
        return this.velocidadeAtual;
    }

    public void acelerar(){
        this.velocidadeAtual += CONST_AUMENTO_VELOCIDADE;
    }

    public void frear(){
        if (this.velocidadeAtual - CONST_DIMINUICAO_VELOCIDADE >= 0){
            this.velocidadeAtual -= CONST_DIMINUICAO_VELOCIDADE;
        } else {
            this.velocidadeAtual = 0.0;
        }
    }

    public void exibirInfo(){
        System.out.println("Marca: " + this.marca + " - Modelo: " + this.modelo + " - Ano de Fabricacao: " + this.anoFabricacao.getYear() + " - Velocidade Atual: " + this.velocidadeAtual);
    }

    public String toString(){
        return "Marca: " + this.marca + " - Modelo: " + this.modelo + " - Ano de Fabricacao: " + this.anoFabricacao.getYear() + " - Velocidade Atual: " + this.velocidadeAtual;
    }

    public Boolean equals(Carro carro){
        return (this.modelo.equals(carro.getModelo()) && this.marca.equals(carro.getMarca()) && getAnoFabricacao() == carro.getAnoFabricacao());
    }
}
