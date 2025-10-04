package pe.edu.upc.bestprice.dtos;

import jakarta.persistence.Column;

public class TipoResenaDTO {
    private int idTipoResena;
    private String tiporeseTipoResena;

    public int getIdTipoResena() {
        return idTipoResena;
    }

    public void setIdTipoResena(int idTipoResena) {
        this.idTipoResena = idTipoResena;
    }

    public String getTiporeseTipoResena() {
        return tiporeseTipoResena;
    }

    public void setTiporeseTipoResena(String tiporeseTipoResena) {
        this.tiporeseTipoResena = tiporeseTipoResena;
    }
}
