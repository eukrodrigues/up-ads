package Exercicio05;

import java.util.ArrayList;
import java.util.List;

public class Colecao {
    List<Carro> carros;

    public Colecao(){
        carros = new ArrayList<>();
    }

    public void listarCarros(){
        for(int i = 0; i < carros.size(); i++){
            System.out.println(i + " - " + carros.get(i).toString());
        }
    }

    public Colecao adicionarCarro(Carro carro){
        carros.add(carro);
        return this;
    }

    public void acelerar(Carro carroAAcelerar){
        for (Carro carro : carros) {
            if(carro.equals(carroAAcelerar)){
                carro.acelerar();
                System.out.println("Carro acelerado! Nova velocidade: " + carro.getVelocidadeAtual());
            }
        }
    }

    public void frear(Carro carroAFrear){
        for (Carro carro : carros) {
            if(carro.equals(carroAFrear)){
                carro.frear();
                System.out.println("Carro freado! Nova velocidade: " + carro.getVelocidadeAtual());
            }
        }
    }

    public List<Carro> getCarros(){
        return carros;
    }
}
