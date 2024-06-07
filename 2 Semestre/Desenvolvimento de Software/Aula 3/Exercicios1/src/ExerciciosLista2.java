import java.util.Scanner;

public class ExerciciosLista2 {
    
    Scanner scan;

    public ExerciciosLista2(){
        scan = new Scanner(System.in);
    }

    public void exercicio14(){
        int an, a1, n, r;

        a1 = lerNumero("Digite o valor de a1");
        n = lerNumero("Digite o valor de n");
        r = lerNumero("Digite o valor de r");

        an = a1 + (n - 1) * r;

        System.out.println("an = " + an);
    }

    public void exercicio15(){
        int x1, y1, x2, y2;
        double distancia;

        x1 = lerNumero("Digite o valor de p1_x1");
        y1 = lerNumero("Digite o valor de p1_y1");
        x2 = lerNumero("Digite o valor de p2_x2");
        y2 = lerNumero("Digite o valor de p2_y2");

        distancia = Math.sqrt(Math.pow(x2 - x1, 2) + (Math.pow(y2 - y1, 2)));

        System.out.println("Distância: " + distancia);
    }

    public void exercicio16(){
        double nota1, nota2, nota3, media;

        nota1 = lerNumeroDouble("Digite o valor da primeira nota: ");
        nota2 = lerNumeroDouble("Digite o valor da segunda nota: ");
        nota3 = lerNumeroDouble("Digite o valor da terceira nota: ");

        media = (nota1 + nota2 + nota3) / 3;

        System.out.println("Média: " + media);
    }

    public void exercicio17(){
        double nota1, nota2, nota3, media, peso1, peso2, peso3;

        nota1 = lerNumeroDouble("Digite o valor da primeira nota: ");
        nota2 = lerNumeroDouble("Digite o valor da segunda nota: ");
        nota3 = lerNumeroDouble("Digite o valor da terceira nota: ");

        peso1 = lerNumeroDouble("Digite o valor do peso da primeira nota: ");
        peso2 = lerNumeroDouble("Digite o valor do peso da segunda nota: ");
        peso3 = lerNumeroDouble("Digite o valor do peso da terceira nota: ");

        media = ((nota1 * peso1) + (nota2 * peso2) + (nota3 * peso3)) / (peso1 + peso2 + peso3);

        System.out.println("Média: " + media);
    }

    public void exercicio18(){
        double nota1, nota2, nota3, media;

        nota1 = lerNumeroDouble("Digite o valor da primeira nota: ");
        nota2 = lerNumeroDouble("Digite o valor da segunda nota: ");
        nota3 = lerNumeroDouble("Digite o valor da terceira nota: ");

        media = 3 / ((1 / nota1) + (1 / nota2) + (1 / nota3));

        System.out.println("Média: " + media);
    }

    public void exercicio19(){
        double raio, altura, volume;
        
        raio = lerNumeroDouble("Digite o valor do Raio: ");
        altura = lerNumeroDouble("Digite o valor da altura: ");

        volume = 3.14 * Math.pow(raio, 2) * altura;

        System.out.println("Volume: " + volume);
    }

    public void exercicio20(){
        int tempo, velocidadeMedia, qtdeLitros;

        tempo = lerNumero("Digite o tempo gasto na viagem (em horas): ");
        velocidadeMedia = lerNumero("Digite a velocidade média da viagem (em km/h): ");

        qtdeLitros = (tempo * velocidadeMedia) / 12;

        System.out.println("Quantidade de litros: " + qtdeLitros);
    }


    private int lerNumero(String texto){
        System.out.println(texto);
        return scan.nextInt();
    }

    private double lerNumeroDouble(String texto){
        System.out.println(texto);
        return scan.nextDouble();
    }
}
