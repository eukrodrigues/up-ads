package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Aluno extends Pessoa {
    private String matricula;
    private double valorMensalidade;
    private List<Servico> servicosContratados;
    private Date dataInicio;
    private Date dataRenovacao;
    private List<Mensalidade> mensalidades;
    private Treino treinoAtual;
    private List<Treino> treinosAnteriores;

    public Treino getTreinoAtual() {
        return treinoAtual;
    }

    public Aluno(String nome, String cpf, String matricula, double valorMensalidade,
            List<Servico> servicosContratados, Date dataInicio) {
        super(nome, cpf);
        this.matricula = matricula;
        this.valorMensalidade = valorMensalidade;
        this.servicosContratados = servicosContratados;
        this.dataInicio = dataInicio;

        gerarMensalidades(dataInicio, 12);
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataRenovacao() {
        return dataRenovacao;
    }

    public void setDataRenovacao(Date dataRenovacao) {
        this.dataRenovacao = dataRenovacao;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public double getValorMensalidade() {
        return valorMensalidade;
    }
    public void setValorMensalidade(double valorMensalidade) {
        this.valorMensalidade = valorMensalidade;
    }
    public List<Servico> getServicosContratados() {
        return servicosContratados;
    }
    public void setServicosContratados(List<Servico> servicosContratados) {
        this.servicosContratados = servicosContratados;
    }
    public void adicionarTreino(Treino treino){
        if(this.treinoAtual != null){
            treinosAnteriores.add(treinoAtual);
        } 
        
        treinoAtual = treino;
    }

    public void pagarMensalidade(){
        for(Mensalidade mensalidade: mensalidades){
            if(!mensalidade.isPago()){
                mensalidade.pagar();
                break;
            }
        }
    }

    private void gerarMensalidades(Date data, int tempoContrato){
        mensalidades = new ArrayList<>();

        for(int i = 0; i < tempoContrato; i++){
            mensalidades.add(new Mensalidade(new Date(data.getYear(), data.getMonth() + i, data.getDay()), this.valorMensalidade));
        }
    }
    
}
