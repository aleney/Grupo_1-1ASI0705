package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "OfertasProducto")
public class OfertasProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOfertasProducto;

    @Column(name = "fechainicioHistorialPrecio", nullable = false)
    private LocalDate fechainicioOfertasProducto;

    @Column(name = "fechafinHistorialPrecio", nullable = false)
    private LocalDate fechafinOfertasProducto;

    @Column(name = "createdAtOfertasProducto", nullable = false)
    private Timestamp createdAtOfertasProducto;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    public OfertasProducto() {
    }

    public OfertasProducto(int idOfertasProducto, LocalDate fechainicioOfertasProducto, LocalDate fechafinOfertasProducto, Timestamp createdAtOfertasProducto, Producto producto) {
        this.idOfertasProducto = idOfertasProducto;
        this.fechainicioOfertasProducto = fechainicioOfertasProducto;
        this.fechafinOfertasProducto = fechafinOfertasProducto;
        this.createdAtOfertasProducto = createdAtOfertasProducto;
        this.producto = producto;
    }

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

    public Timestamp getCreatedAtOfertasProducto() {
        return createdAtOfertasProducto;
    }

    public void setCreatedAtOfertasProducto(Timestamp createdAtOfertasProducto) {
        this.createdAtOfertasProducto = createdAtOfertasProducto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
