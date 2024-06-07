import java.util.Scanner;

public class InterfaceInput {
    private Scanner scan;

    public InterfaceInput(){
        scan = new Scanner(System.in);
    }

    public String lerTexto(String mensagem){
        System.out.println(mensagem);
        return scan.nextLine();
    }

    public Double lerDouble(String mensagem){
        System.out.println(mensagem);
        return scan.nextDouble();
    }
}
