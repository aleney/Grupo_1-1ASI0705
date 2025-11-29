package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Producto;
import pe.edu.upc.bestprice.entities.Tienda;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class HistorialPrecioDTOList {
    private int idHistorialPrecio;
    private BigDecimal precioHistorialPrecio;
    private LocalDate fechaHistorialPrecio;
    private LocalDateTime createdAtHistorialPrecio;
    private Producto producto;
    private Tienda tienda;

    public int getIdHistorialPrecio() {
        return idHistorialPrecio;
    }

    public void setIdHistorialPrecio(int idHistorialPrecio) {
        this.idHistorialPrecio = idHistorialPrecio;
    }

    public BigDecimal getPrecioHistorialPrecio() {
        return precioHistorialPrecio;
    }

    public void setPrecioHistorialPrecio(BigDecimal precioHistorialPrecio) {
        this.precioHistorialPrecio = precioHistorialPrecio;
    }

    public LocalDate getFechaHistorialPrecio() {
        return fechaHistorialPrecio;
    }

    public void setFechaHistorialPrecio(LocalDate fechaHistorialPrecio) {
        this.fechaHistorialPrecio = fechaHistorialPrecio;
    }

    public LocalDateTime getCreatedAtHistorialPrecio() {
        return createdAtHistorialPrecio;
    }

    public void setCreatedAtHistorialPrecio(LocalDateTime createdAtHistorialPrecio) {
        this.createdAtHistorialPrecio = createdAtHistorialPrecio;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
