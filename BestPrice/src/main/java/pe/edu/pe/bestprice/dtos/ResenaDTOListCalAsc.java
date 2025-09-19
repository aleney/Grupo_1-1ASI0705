package pe.edu.pe.bestprice.dtos;

import pe.edu.pe.bestprice.entities.TipoResena;

public class ResenaDTOListCalAsc {
    private int calificacionResena;
    private TipoResena tipoResena;

    public int getCalificacionResena() {
        return calificacionResena;
    }

    public void setCalificacionResena(int calificacionResena) {
        this.calificacionResena = calificacionResena;
    }

    public TipoResena getTipoResena() {
        return tipoResena;
    }

    public void setTipoResena(TipoResena tipoResena) {
        this.tipoResena = tipoResena;
    }
}
