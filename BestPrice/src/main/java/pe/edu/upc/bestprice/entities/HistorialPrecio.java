package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

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

    @CreationTimestamp
    @Column(name = "createdAtHistorialPrecio", nullable = true, updatable = false)
    private LocalDateTime createdAtHistorialPrecio;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    public HistorialPrecio() {
    }

    public HistorialPrecio(int idHistorialPrecio, BigDecimal precioHistorialPrecio, LocalDate fechaHistorialPrecio, Producto producto, Tienda tienda) {
        this.idHistorialPrecio = idHistorialPrecio;
        this.precioHistorialPrecio = precioHistorialPrecio;
        this.fechaHistorialPrecio = fechaHistorialPrecio;
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
