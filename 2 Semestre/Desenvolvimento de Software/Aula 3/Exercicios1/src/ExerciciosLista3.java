import java.util.Scanner;

public class ExerciciosLista3 {
    
    Scanner scan;

    public ExerciciosLista3(){
        scan = new Scanner(System.in);
    }

    private int lerNumero(String texto){
        System.out.println(texto);
        return scan.nextInt();
    }

    private double lerNumeroDouble(String texto){
        System.out.println(texto);
        return scan.nextDouble();
    }

    public void exercicio1(){
        int[] numeros = new int[5];
        int soma = 0;
        double media;
        
        for(int i = 0; i < numeros.length; i++){
            numeros[i] = lerNumero("Digite o valor (" + i + "): ");
            soma = soma + numeros[i];
        }

        media = soma / numeros.length;

        for(int i = 0; i < numeros.length; i++){
            System.out.print("Números[" + i + "] = " + numeros[i]);
            if(numeros[i] < media)
                System.out.println(" - Menor do que média " + media);
            else if(numeros[i] > media)
                System.out.println(" - Maior do que média " + media);
            else
                System.out.println(" - Igual a média " + media);
        }
        
    }

    public void exercicio2(){
        int[] vetor = new int[10];

        for(int i = 0; i < vetor.length; i++){
            vetor[i] = lerNumero("Digite o valor (" + i + "): ");
        }
    }

}
