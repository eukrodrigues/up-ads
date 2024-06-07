package Implementacao;

import java.sql.Date;

/**
 * NotaFiscal
 */
public class NotaFiscal {

    private Integer codigo; 
    private Date dataEmissao; 
    private Double valor;

    public NotaFiscal(Integer codigo, Date dataEmissao, Double valor) { 
        super();
 
        this.codigo = codigo;
        this.dataEmissao = dataEmissao;  
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NotaFiscal other = (NotaFiscal) obj;
        if (codigo == null) {
            if (other.codigo != null)
                return false;
        } else if (!codigo.equals(other.codigo))
            return false;
        return true;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Date getDataEmissao() {
        return dataEmissao;
    }

    public Double getValor() {
        return valor;
    }
 
}