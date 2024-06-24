package enums;

import exceptions.TurnoNaoEncontradoException;

public enum Turno {
    Manha(1), Tarde(2), Noite(3);

    private int idTurno;

    private Turno(int idTurno){
        this.idTurno = idTurno;
    }

    private int getIdTurno(){
        return this.idTurno;
    }

    public static Turno fromId(int idTurno){
        for(Turno turno : Turno.values()){
            if(turno.getIdTurno() == idTurno){
                return turno;
            }
        }

        throw new TurnoNaoEncontradoException();
    }
}
