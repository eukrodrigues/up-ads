public class Aluno{
    private string _nome;
    public string Nome {
        get => _nome;
    }
    private DateTime _dataNascimento;
    public DateTime DataNascimento{
        get => _dataNascimento;
    }

    public Aluno(string _nome, DateTime _dataNascimento){
        this._nome = _nome;
        this._dataNascimento = _dataNascimento;
    }

}