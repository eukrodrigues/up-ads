package Exercicio03;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Banco banco = new Banco("Banco do Kelvin");
        int opcao;

        System.out.println("Bem vindo ao " + banco.getNomeDoBanco());

        do {
            System.out.println("Digite uma das opções abaixo: ");
            System.out.println("1 - Criar Conta Bancária\n2 - Consultar Saldo\n3 - Realizar Saque\n4 - Realizar Depósito\n5 - Sair");
        
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    banco = criarContaBancaria(banco, scan);
                    break;
                case 2:
                    consultarSaldo(banco, scan);
                    break;
                case 3:
                    banco = realizarSaque(banco, scan);
                    break;
                case 4:
                    banco = realizarDeposito(banco, scan);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;
            }
        } while (opcao != 5);

        scan.close();
    }

    private static Banco criarContaBancaria(Banco banco, Scanner scan){
        String nomeTitular, numeroConta;

        scan.nextLine();
        nomeTitular = getTexto("Digite o nome do Titular", scan);
        numeroConta = getTexto("Digite o numero da conta: ", scan);

        System.out.println("Conta adicionada com sucesso!");
        return banco.adicionarContaBancaria(new ContaBancaria(numeroConta, nomeTitular, 0.0));
    }

    private static void consultarSaldo(Banco banco, Scanner scan){
        String nomeTitular, numeroConta;
        Optional<ContaBancaria> login;

        scan.nextLine();
        nomeTitular = getTexto("Digite o nome do Titular", scan);
        numeroConta = getTexto("Digite o numero da conta: ", scan);
        login = banco.getContaBancaria(nomeTitular, numeroConta);

        if (login.isPresent()){
            ContaBancaria conta = login.get();
            System.out.println("Saldo: R$" + conta.getSaldo());
        } else {
            System.out.println("Conta inexistente!");
        }
    }

    private static Banco realizarSaque(Banco banco, Scanner scan){
        String nomeTitular, numeroConta;
        Double valor;
        Optional<ContaBancaria> login;

        scan.nextLine();
        nomeTitular = getTexto("Digite o nome do Titular: ", scan);
        numeroConta = getTexto("Digite o numero da conta: ", scan);
        login = banco.getContaBancaria(nomeTitular, numeroConta);

        if (login.isPresent()){
            valor = getDouble("Digite o valor que deseja sacar: ", scan);
            if (banco.sacar(login.get(), valor)){
                System.out.println("Saque realizado com sucesso!");
            } else {
                System.out.println("Saque não realizado. Conta com saldo insuficiente.");
            }
        } else {
            System.out.println("Conta inexistente!");
        }

        return banco;
    }

    private static Banco realizarDeposito(Banco banco, Scanner scan){
        String nomeTitular, numeroConta;
        Double valor;
        Optional<ContaBancaria> login;

        scan.nextLine();
        nomeTitular = getTexto("Digite o nome do Titular: ", scan);
        numeroConta = getTexto("Digite o numero da conta: ", scan);
        login = banco.getContaBancaria(nomeTitular, numeroConta);

        if (login.isPresent()){
            valor = getDouble("Digite o valor que deseja depositar : ", scan);
            banco.depositar(login.get(), valor);
        } else {
            System.out.println("Conta inexistente!");
        }

        return banco;
    }

    private static String getTexto(String mensagem, Scanner scan){
        String retorno;

        System.out.println(mensagem);
        retorno = scan.nextLine();

        return retorno;
    }

    private static Double getDouble(String mensagem, Scanner scan){
        Double retorno;

        System.out.println(mensagem);
        retorno = scan.nextDouble();

        return retorno;
    }
}
