import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Scanner scan = new Scanner(System.in);
        int opcao;

        funcionarios.add(new Desenvolvedor("Jose", "4321", 6000, "C#, Java"));
        funcionarios.add(new Desenvolvedor("Maria", "987", 5500, "Java"));
        funcionarios.add(new Estagiario("Livia", "234324", 1000, 6, funcionarios.get(0)));
        funcionarios.add(new Gerente("Mario", "8978998", 10000, 12000, new ArrayList<>(Arrays.asList(funcionarios.get(0), funcionarios.get(1), funcionarios.get(2)))));

        do{
            System.out.println("--------------------------");
            System.out.println("1 - Incluir Gerente");
            System.out.println("2 - Incluir Desenvolvedor");
            System.out.println("3 - Incluir Estagiário");
            System.out.println("4 - Remover Funcionario");
            System.out.println("5 - Exibir Funcionarios");
            System.out.println("--------------------------");
            System.out.println("Selecione uma opção: ");
            opcao = scan.nextInt();
            scan.nextLine();

            switch (opcao) {
                case 1:
                    adicionarGerente(funcionarios, scan);
                    break;
                case 2:
                    adicionarDesenvolvedor(funcionarios, scan);
                    break;
                case 3:
                    adicionarEstagiario(funcionarios, scan);
                    break;
                case 4:
                    removerFuncionario(funcionarios, scan);
                    break;
                case 5:
                    listarFuncionarios(funcionarios);
                    break;
                default:
                    break;
            }
        }while(true);
    }

    private static void adicionarGerente(List<Funcionario> funcionarios, Scanner scan){
        String nome, matricula;
        double salarioBase, bonusAnual;

        System.out.println("-------------------------");
        System.out.println("    Adicionar Gerente    ");
        System.out.println("-------------------------");

        nome = getString("Digite o nome: ", scan);
        matricula = getString("Digite a matricula: ", scan);
        salarioBase = getDouble("Digite o salario base: ", scan);
        bonusAnual = getDouble("Digite o bonus anual: ", scan);

        funcionarios.add(new Gerente(nome, matricula, salarioBase, bonusAnual, null));
    }

    private static void adicionarDesenvolvedor(List<Funcionario> funcionarios, Scanner scan){
        String nome, matricula, tecnologias;
        double salarioBase;
        
        System.out.println("-------------------------");
        System.out.println(" Adicionar Desenvolvedor ");
        System.out.println("-------------------------");

        nome = getString("Digite o nome: ", scan);
        matricula = getString("Digite a matricula: ", scan);
        tecnologias = getString("Digite as tecnologias: ", scan);
        salarioBase = getDouble("Digite o salario base: ", scan);

        funcionarios.add(new Desenvolvedor(nome, matricula, salarioBase, tecnologias));
    }

    private static void adicionarEstagiario(List<Funcionario> funcionarios, Scanner scan){
        int horasDeTrabalho;
        String nome, matricula;
        double salarioBase;

        System.out.println("-------------------------");
        System.out.println("   Adicionar Estagiario  ");
        System.out.println("-------------------------");

        nome = getString("Digite o nome: ", scan);
        matricula = getString("Digite a matricula: ", scan);
        horasDeTrabalho = getInt("Horas trabalhadas: ", scan);
        salarioBase = getDouble("Digite o salario base: ", scan);

        funcionarios.add(new Estagiario(nome, matricula, salarioBase, horasDeTrabalho, null));
    }

    private static void removerFuncionario(List<Funcionario> funcionarios, Scanner scan){
        int opcao;

        for(int i = 0; i  < funcionarios.size(); i++){
            System.out.println((i + 1) + " - " + funcionarios.get(i).nome + " - " + funcionarios.get(i).matricula);
        }
        System.out.println("-------------------------");
        opcao = getInt("Digite o numero do funcionario que deseja remover: ", scan);

        funcionarios.remove(opcao - 1);
    }

    private static void listarFuncionarios(List<Funcionario> funcionarios){
        for(int i = 0; i  < funcionarios.size(); i++){
            System.out.println((i + 1) + " - " + funcionarios.get(i).nome + " - " + funcionarios.get(i).matricula);
        }
    }

    private static String getString(String mensagem, Scanner scan){
        System.out.println(mensagem);
        return scan.nextLine();
    }

    private static double getDouble(String mensagem, Scanner scan){
        System.out.println(mensagem);
        return scan.nextDouble();
    }

    private static int getInt(String mensagem, Scanner scan){
        System.out.println(mensagem);
        return scan.nextInt();
    }
}
