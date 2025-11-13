package pe.edu.upc.bestprice.dtos;

public class TipoResenaDTO {

    private int idTipoResena;
    private String tiporeseTipoResena;

    public TipoResenaDTO() {
    }

    public TipoResenaDTO(int idTipoResena, String tiporeseTipoResena) {
        this.idTipoResena = idTipoResena;
        this.tiporeseTipoResena = tiporeseTipoResena;
    }

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
