import java.time.Year;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args){
        // int numero1 = 40;
        // float numero2 = 55.3f;
        // boolean seila = false;
        // String valor = "Textinho";

        // System.out.println("Hello World" + numero1 + numero2 + seila + "algo" + valor);
        
        Scanner scan = new Scanner(System.in);
        // DESAFIO 1
        // System.out.println("Olá! Qual o seu nome?");
        // String nome = scan.nextLine();

        // System.out.println("Olá! Bem-vindo(a) " + nome);

        // System.out.println("Em que ano você nasceu, " + nome + "?");
        // int anoNascimento = scan.nextInt();
        // System.out.println("Que legal! Você deve ter " + (Year.now().getValue() - anoNascimento) + " anos.");

        //DESAFIO 2
        // System.out.println("Digite o dia do seu nascimento: ");
        // int dia = scan.nextInt();

        // System.out.println("Digite o mês do seu nascimento: ");
        // int mes = scan.nextInt();

        // System.out.println("Digite o ano do seu nascimento: ");
        // int ano = scan.nextInt();

        // System.out.println("Você nasceu no dia " + dia + " de " + mes + " de " + ano + ".");

        //DESAFIO 3
        System.out.println("Digite o primeiro numero:");
        int numero1 = scan.nextInt();

        System.out.println("Digite o segundo numero:");
        int numero2 = scan.nextInt();

        System.out.println("A soma entre " + numero1 + " e " + numero2 + " é: " + (numero1 + numero2));


    }
}