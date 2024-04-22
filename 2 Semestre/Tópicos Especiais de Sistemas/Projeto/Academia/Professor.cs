public class Professor{
    private string _nome;
    public string Nome {
        get => _nome;
    }
    private DateTime _dataNascimento;
    public DateTime DataNascimento{
        get => _dataNascimento;
    }
    private string _turno;
    public string Turno {
        get => _turno;
        set => _turno = value;
    }

    public Professor(string _nome, DateTime _dataNascimento, string _turno){
        this._nome = _nome;
        this._dataNascimento = _dataNascimento;
        this._turno = _turno;
    }
}