public class Desenvolvedor extends Funcionario implements Trabalhavel{
    String tecnologias;

    public Desenvolvedor(String nome, String matricula, double salarioBase, String tecnologias){
        super(nome, matricula, salarioBase);
        this.tecnologias = tecnologias;
    }

    @Override
    public double calcularSalario(){
        return salarioBase;
    }

    @Override
    public void trabalhar(){
        System.out.println("Desenvolvedor trabalhando");
    }

    @Override
    public void relatarProgresso(){
        System.out.println("Desenvolvedor relatando progresso");
    }

}
