package pe.edu.upc.bestprice.dtos;


import pe.edu.upc.bestprice.entities.Tiendas;

public class TipoTiendaDTO {

    private int idTipoTienda;
    private String nombreTipoTienda;
    private Tiendas tiendas;

    public int getIdTipoTienda() {
        return idTipoTienda;
    }

    public void setIdTipoTienda(int idTipoTienda) {
        this.idTipoTienda = idTipoTienda;
    }

    public String getNombreTipoTienda() {
        return nombreTipoTienda;
    }

    public void setNombreTipoTienda(String nombreTipoTienda) {
        this.nombreTipoTienda = nombreTipoTienda;
    }

    public Tiendas getTiendas() {
        return tiendas;
    }

    public void setTiendas(Tiendas tiendas) {
        this.tiendas = tiendas;
    }
}
