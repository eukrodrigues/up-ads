public class Estagiario extends Funcionario implements Trabalhavel{
    int horasDeTrabalho;
    Funcionario supervisor;

    public Estagiario(String nome, String matricula, double salarioBase, int horasDeTrabalho, Funcionario supervisor){
        super(nome, matricula, salarioBase);
        this.horasDeTrabalho = horasDeTrabalho;
        this.supervisor = supervisor;
    }

    @Override
    public double calcularSalario(){
        return salarioBase;
    }

    @Override
    public void trabalhar(){
        System.out.println("Estagiario trabalhando");
    }

    @Override
    public void relatarProgresso(){
        System.out.println("Estagiario relatando progresso");
    }
}
