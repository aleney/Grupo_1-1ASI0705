package pe.edu.upc.bestprice.dtos;

public class TipoResenaDTOInsert {
    private String tiporeseTipoResena;

    public TipoResenaDTOInsert() {
    }

    public TipoResenaDTOInsert(String tiporeseTipoResena) {
        this.tiporeseTipoResena = tiporeseTipoResena;
    }

    public String getTiporeseTipoResena() {
        return tiporeseTipoResena;
    }

    public void setTiporeseTipoResena(String tiporeseTipoResena) {
        this.tiporeseTipoResena = tiporeseTipoResena;
    }
}
