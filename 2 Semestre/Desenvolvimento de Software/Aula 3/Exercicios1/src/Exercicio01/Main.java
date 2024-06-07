package Exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcao;
        Double numero1, numero2, resultado;
        String operacao = null;
        Scanner scan = new Scanner(System.in);

        System.out.println("######################");
        System.out.println("Calculadora do Estudante de Programação");
        System.out.println("######################\n");

        do {
            System.out.println("Digite o primeiro número: ");
            numero1 = scan.nextDouble();

            System.out.println("Digite o segundo número: ");
            numero2 = scan.nextDouble();

            do{
                System.out.println("Digite a operação que deseja realizar: ");
                System.out.println("1 - Soma\n2 - Subtração\n3 - Multiplicação\n4 - Divisão\n5 - Sair");

                opcao = scan.nextInt();

                if (opcao < 1 || opcao > 5)
                    System.out.println("Opção Inválida!");
                
                if (opcao == 4 && numero2 == 0){
                    System.out.println("Não é possível fazer divisão por 0");
                    opcao = -1;
                }

            }while(opcao < 1 || opcao > 5);

            resultado = null;

            switch (opcao) {
                case 1:
                    operacao = "soma";
                    resultado = Calculadora.somar(numero1, numero2);
                    break;
                case 2:
                    operacao = "subtração";
                    resultado = Calculadora.subtrair(numero1, numero2);
                    break;
                case 3:
                    operacao = "multiplicação";
                    resultado = Calculadora.multiplicar(numero1, numero2);
                    break;
                case 4:
                    operacao = "divisão";
                    resultado = Calculadora.dividir(numero1, numero2);
                    break;
                default:
                    break;
            }

            if(resultado != null)
                System.out.println("O resultado da " + operacao + " de " + numero1 + " e " + numero2 + " é: " + resultado);

        } while(opcao != 5);
    }
}
