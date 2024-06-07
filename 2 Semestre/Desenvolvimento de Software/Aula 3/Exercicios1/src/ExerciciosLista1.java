import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExerciciosLista1 {

    Scanner scan;

    public ExerciciosLista1(){
        scan = new Scanner(System.in);
    }

    public void exercicio1(){
        int numero;

        System.out.println("Digite um numero:");
        numero = scan.nextInt();

        if (numero > 10)
            System.out.println("Numero maior do que 10!");
        else
            System.out.println("Número menor ou igual a 10!");
    }

    public void exercicio2(){
        int numero1, numero2;

        System.out.println("Digite um número: ");
        numero1 = scan.nextInt();

        System.out.println("Digite outro número: ");
        numero2 = scan.nextInt();

        if (numero1 > numero2)
            System.out.println("O número " + numero1 + " é maior do que o número " + numero2);
        else if (numero1 < numero2)
            System.out.println("O número " + numero2 + " é maior do que o número " + numero1);
        else
            System.out.println("Os números são iguais");

        System.out.println("Soma dos números: " + (numero1 + numero2));

    }

    public void exercicio3(){
        int numero1, numero2;

        System.out.println("Digite um número: ");
        numero1 = scan.nextInt();

        System.out.println("Digite outro número: ");
        numero2 = scan.nextInt();

        if (numero1 > numero2)
            System.out.println("O número " + numero1 + " é maior do que o número " + numero2);
        else if (numero1 < numero2)
            System.out.println("O número " + numero2 + " é maior do que o número " + numero1);
        else
            System.out.println("A entrada é inválida.");
    }

    public void exercicio4(){
        int numero1, numero2;

        System.out.println("Digite um número: ");
        numero1 = scan.nextInt();

        System.out.println("Digite outro número: ");
        numero2 = scan.nextInt();

        System.out.println("Soma: " + (numero1 + numero2));
        System.out.println("Subtração: " + (numero1 - numero2));
        System.out.println("Multiplicação: " + (numero1 * numero2));
        System.out.println("Divisão: " + (numero1 / numero2));
    }

    public void exercicio5(){
        int varA, varB, varAux;

        System.out.println("Digite valor da Variavel A: ");
        varA = scan.nextInt();

        System.out.println("Digite valor da Variavel B: ");
        varB = scan.nextInt();

        System.out.println("Valor Variável A: " + varA);
        System.out.println("Valor Variável B: " + varB);

        varAux = varA;
        varA = varB;
        varB = varAux;

        System.out.println("Valor Variável A: " + varA);
        System.out.println("Valor Variável B: " + varB);
    }

    public void exercicio6(){
        double tempCelsius, tempFahrenheit;

        System.out.println("Digite o valor da temperatura em Celsius: ");
        tempCelsius = scan.nextDouble();

        tempFahrenheit = (9 * tempCelsius + 160) / 5;

        System.out.println("Temperatura em graus Fahrenheit: " + tempFahrenheit);
    }

    public void exercicio7(){
        int numero;

        System.out.println("Digite o valor de um numero: ");
        numero = scan.nextInt();

        if(numero >= 100 && numero <= 200)
            System.out.println("Numero está dentro do intervalo de 100 a 200");
        else
            System.out.println("Número não está dentro do intervalo de 100 a 200");
    }

    public void exercicio8(){
        int numero;

        System.out.println("Digite o valor de um numero: ");
        numero = scan.nextInt();

        if(numero >= 50)
            System.out.println("Número é maior ou igual a 50");
        else
            System.out.println("Número é menor que 50");
    }

    public void exercicio9(){
        exercicio2();
    }

    public void exercicio10(){
        int numero;

        System.out.println("Digite um valor: ");
        numero = scan.nextInt();

        switch (numero) {
            case 1:
                System.out.println("Número Um");
                break;
            case 2:
                System.out.println("Número Dois");
                break;
            case 3:
                System.out.println("Número Três");
                break;
            case 4:
                System.out.println("Número Quatro");
                break;
            case 5:
                System.out.println("Número Cinco");
                break;
            default:
                System.out.println("Número Inválido!");
                break;
        }
    }

    public void exercicio11(){
        List<Integer> numeros = new ArrayList<Integer>();

        System.out.println("Digite o primeiro valor: ");
        numeros.add(scan.nextInt());

        System.out.println("Digite o segundo valor: ");
        numeros.add(scan.nextInt());

        System.out.println("Digite o terceiro valor: ");
        numeros.add(scan.nextInt());

        Collections.sort(numeros);

        System.out.println(numeros);
    }

    public void exercicio12(){
        int numero;

        System.out.println("Digite um mês: ");
        numero = scan.nextInt();

        switch (numero) {
            case 1:
                System.out.println("Janeiro");
                break;
            case 2:
                System.out.println("Fevereiro");
                break;
            case 3:
                System.out.println("Março");
                break;
            case 4:
                System.out.println("Abril");
                break;
            case 5:
                System.out.println("Maio");
                break;
            case 6:
                System.out.println("Junho");
                break;
            case 7:
                System.out.println("Julho");
                break;
            case 8:
                System.out.println("Agosto");
                break;
            case 9:
                System.out.println("Setembro");
                break;
            case 10:
                System.out.println("Outubro");
                break;
            case 11:
                System.out.println("Novembro");
                break;
            case 12:
                System.out.println("Dezembro");
                break;
            default:
                System.out.println("Mês inválido!");
                break;
        }
    }

}
