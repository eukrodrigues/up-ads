class Exercicio
{
    private string _nome;
    public string Nome {
        get => _nome;
    }
    private int _numero;
    public int Numero {
        get => _numero;
    }
    private int _dificuldade;
    public int Dificuldade {
        get => _dificuldade;
    }

    public Exercicio(string _nome, int _numero, int _dificuldade){
        this._nome = _nome;
        this._numero = _numero;
        this._dificuldade = _dificuldade;
    }
}