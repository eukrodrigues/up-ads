package entities;
import enums.Turno;

public class Funcionario extends Pessoa {
    private Turno turno;
    private double salario;

    public Funcionario(String nome, String cpf, Turno turno, double salario) {
        super(nome, cpf);
        this.turno = turno;
        this.salario = salario;
    }
    public Turno getTurno() {
        return turno;
    }
    public void setTurno(Turno turno) {
        this.turno = turno;
    }
    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
}
