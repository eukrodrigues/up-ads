package entities;
import java.util.Date;

public class Mensalidade {
    private Date dataVencimento;
    private double valor;
    private boolean status;
    
    public Mensalidade(Date dataVencimento, double valor) {
        this.dataVencimento = dataVencimento;
        this.valor = valor;
        this.status = false;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public boolean isPago() {
        return status;
    }
    public void pagar() {
        this.status = true;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
