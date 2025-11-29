package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Producto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfertasProductoDTO {
    private int idOfertasProducto;
    private LocalDate fechainicioOfertasProducto;
    private LocalDate fechafinOfertasProducto;
    private LocalDateTime createdAtOfertasProducto;
    private Producto producto;

    public int getIdOfertasProducto() {
        return idOfertasProducto;
    }

    public void setIdOfertasProducto(int idOfertasProducto) {
        this.idOfertasProducto = idOfertasProducto;
    }

    public LocalDate getFechainicioOfertasProducto() {
        return fechainicioOfertasProducto;
    }

    public void setFechainicioOfertasProducto(LocalDate fechainicioOfertasProducto) {
        this.fechainicioOfertasProducto = fechainicioOfertasProducto;
    }

    public LocalDate getFechafinOfertasProducto() {
        return fechafinOfertasProducto;
    }

    public void setFechafinOfertasProducto(LocalDate fechafinOfertasProducto) {
        this.fechafinOfertasProducto = fechafinOfertasProducto;
    }

    public LocalDateTime getCreatedAtOfertasProducto() {
        return createdAtOfertasProducto;
    }

    public void setCreatedAtOfertasProducto(LocalDateTime createdAtOfertasProducto) {
        this.createdAtOfertasProducto = createdAtOfertasProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
