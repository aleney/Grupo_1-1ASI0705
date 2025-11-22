package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "HistorialBusqueda")
public class HistorialBusqueda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorialBusqueda;

    @CreationTimestamp
    @Column(name = "fechabusqueHistorialBusqueda",nullable = false,updatable = false)
    private LocalDate fechabusqueHistorialBusqueda;

    @Column(name = "productoidHistoriaBusqueda",nullable = false)
    private int productoidHistoriaBusqueda;

    @Column(name = "usuarioidHistoriaBusqueda")
    private int usuarioidHistoriaBusqueda;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public HistorialBusqueda(Producto producto ,Usuario usuario){
        this.producto = producto;
        this.usuario = usuario;
    }
    public HistorialBusqueda() {
    }

    public HistorialBusqueda(int idHistorialBusqueda, LocalDate fechabusqueHistorialBusqueda, int productoidHistoriaBusqueda, int usuarioidHistoriaBusqueda) {
        this.idHistorialBusqueda = idHistorialBusqueda;
        this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda;
        this.productoidHistoriaBusqueda = productoidHistoriaBusqueda;
        this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda;
    }


    public int getIdHistorialBusqueda() {
        return idHistorialBusqueda;
    }

    public void setIdHistorialBusqueda(int idHistorialBusqueda) {
        this.idHistorialBusqueda = idHistorialBusqueda;
    }

    public LocalDate getFechabusqueHistorialBusqueda() {
        return fechabusqueHistorialBusqueda;
    }

    public void setFechabusqueHistorialBusqueda(LocalDate fechabusqueHistorialBusqueda) {
        this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda;
    }

    public int getProductoidHistoriaBusqueda() {
        return productoidHistoriaBusqueda;
    }

    public void setProductoidHistoriaBusqueda(int productoidHistoriaBusqueda) {
        this.productoidHistoriaBusqueda = productoidHistoriaBusqueda;
    }

    public int getUsuarioidHistoriaBusqueda() {
        return usuarioidHistoriaBusqueda;
    }

    public void setUsuarioidHistoriaBusqueda(int usuarioidHistoriaBusqueda) {
        this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda;
    }
}
