package entities;
import java.util.List;

import enums.Turno;

public class Professor extends Funcionario {
    private List<Servico> servicosAtendidos;
    private String codigoProfessor;

    public Professor(String nome, String cpf, Turno turno, double salario,
            List<Servico> servicosAtendidos, String codigoProfessor) {
        super(nome, cpf, turno, salario);
        this.servicosAtendidos = servicosAtendidos;
        this.codigoProfessor = codigoProfessor;
    }

    public List<Servico> getServicosAtendidos() {
        return servicosAtendidos;
    }

    public void setServicosAtendidos(List<Servico> servicosAtendidos) {
        this.servicosAtendidos = servicosAtendidos;
    }

    public String getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(String codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }
    
    
}
