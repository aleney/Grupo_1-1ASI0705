package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.Producto;

public class CanastaDetalleDTOInsert {

    private Integer idCanastaDetalle;
    private int cantidadCanastaDetalle;
    private Producto producto;
    private Canasta canasta;

    public Integer getIdCanastaDetalle() {
        return idCanastaDetalle;
    }

    public void setIdCanastaDetalle(Integer idCanastaDetalle) {
        this.idCanastaDetalle = idCanastaDetalle;
    }

    public int getCantidadCanastaDetalle() {
        return cantidadCanastaDetalle;
    }

    public void setCantidadCanastaDetalle(int cantidadCanastaDetalle) {
        this.cantidadCanastaDetalle = cantidadCanastaDetalle;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Canasta getCanasta() {
        return canasta;
    }

    public void setCanasta(Canasta canasta) {
        this.canasta = canasta;
    }
}
