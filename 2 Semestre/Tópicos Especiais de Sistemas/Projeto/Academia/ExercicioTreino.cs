class ExercicioTreino
{
    private Exercicio _exercicio;
    public Exercicio Exercicio{
        get => _exercicio;
    }
    private int _repeticoes;
    public int Repeticoes {
        get => _repeticoes;
    }
    private int _series;
    public int Series {
        get => _series;
    }

    public ExercicioTreino(Exercicio _exercicio, int _repeticoes, int _series){
        this._exercicio = _exercicio;
        this._repeticoes = _repeticoes;
        this._series = _series;
    }
}