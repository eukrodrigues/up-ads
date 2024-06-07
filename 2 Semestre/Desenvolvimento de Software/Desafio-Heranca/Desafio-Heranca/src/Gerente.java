import java.util.List;

public class Gerente extends Funcionario implements Trabalhavel{
    double bonusAnual;
    List<Funcionario> equipe;

    public Gerente(String nome, String matricula, double salarioBase, double bonusAnual, List<Funcionario> equipe){
        super(nome, matricula, salarioBase);
        this.bonusAnual = bonusAnual;
        this.equipe = equipe;
    }

    @Override
    public double calcularSalario(){
        return (salarioBase + (bonusAnual / 12));
    }

    @Override
    public void trabalhar(){
        System.out.println("Gerente trabalhando");
    }

    @Override
    public void relatarProgresso(){
        System.out.println("Gerente relatando progresso");
    }

}
