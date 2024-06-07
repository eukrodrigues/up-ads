package Exercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
    private String nomeDoBanco;
    private List<ContaBancaria> contas;

    public Banco(String nomeDoBanco){
        this.nomeDoBanco = nomeDoBanco;
        contas = new ArrayList<>();
        carregarContas();
    }

    public String getNomeDoBanco(){
        return this.nomeDoBanco;
    }

    public Banco adicionarContaBancaria(ContaBancaria contaBancaria){
        contas.add(contaBancaria);
        return this;
    }

    public Optional<ContaBancaria> getContaBancaria(String nomeTitular, String numeroConta){
        return contas.stream()
                     .filter(conta -> conta.equals(new ContaBancaria(numeroConta, nomeTitular, null)))
                     .findFirst();
    }

    public Boolean sacar(ContaBancaria conta, Double valor){
        for(ContaBancaria contaBancaria : contas){
            if(contaBancaria.equals(conta)){
                return contaBancaria.sacar(valor);
            }
        }
        
        return false;
    }

    public void depositar(ContaBancaria conta, Double valor){
        for(ContaBancaria contaBancaria : contas){
            if(contaBancaria.equals(conta)){
                contaBancaria.depositar(valor);
            }
        }
    }

    private void carregarContas(){
        this.contas.add(new ContaBancaria("0101", "Kelvin", 10.0));
    }

    
}
