package Exercicio03;

public class ContaBancaria {
    private final String numeroConta;
    private final String nomeTitular;
    private Double saldo;

    public ContaBancaria(String numeroConta, String nomeTitular, Double saldo){
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public String getNumeroConta(){
        return this.numeroConta;
    }

    public String getNomeTitular(){
        return this.nomeTitular;
    }

    public Double getSaldo(){
        return saldo;
    }

    public Boolean sacar(Double valor){
        if (valor <= this.saldo) {
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public void depositar(Double valor){
        saldo += valor;
    }

    public Boolean equals(ContaBancaria conta){
        return (this.nomeTitular.equals(conta.getNomeTitular()) && 
                this.numeroConta.equals(conta.getNumeroConta()));
    }
}
