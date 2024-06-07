Public Class Exercicio{

    Scanner scan;

    public static void main(String[] args){
        scan = new Scanner(System.in);

        exercicio1();
    }

    private void exercicio1(){
        int numero;

        System.out.println("Digite um numero:");
        numero = scan.nextInt;

        if (numero > 10)
            System.out.println("Numero maior do que 10!");
        else
            System.out.println("Número menor ou igual a 10!")


    }
}