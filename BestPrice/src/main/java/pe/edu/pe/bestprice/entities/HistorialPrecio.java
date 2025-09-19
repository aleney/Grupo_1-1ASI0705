package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "HistorialPrecio")
public class HistorialPrecio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialPrecio;

    @Column(name = "precioHistorialPrecio", precision = 10, scale = 2, nullable = false)
    private BigDecimal precioHistorialPrecio;

    @Column(name = "fechaHistorialPrecio", nullable = false)
    private LocalDate fechaHistorialPrecio;

    @Column(name = "createdAtHistorialPrecio", nullable = false)
    private Timestamp createdAtHistorialPrecio;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    public HistorialPrecio() {
    }

    public HistorialPrecio(int idHistorialPrecio, BigDecimal precioHistorialPrecio, LocalDate fechaHistorialPrecio, Timestamp createdAtHistorialPrecio, Producto producto, Tienda tienda) {
        this.idHistorialPrecio = idHistorialPrecio;
        this.precioHistorialPrecio = precioHistorialPrecio;
        this.fechaHistorialPrecio = fechaHistorialPrecio;
        this.createdAtHistorialPrecio = createdAtHistorialPrecio;
        this.producto = producto;
        this.tienda = tienda;
    }

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

    public Timestamp getCreatedAtHistorialPrecio() {
        return createdAtHistorialPrecio;
    }

    public void setCreatedAtHistorialPrecio(Timestamp createdAtHistorialPrecio) {
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
