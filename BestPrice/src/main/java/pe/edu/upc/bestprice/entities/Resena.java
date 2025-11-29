package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table (name = "Resena")
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idResena;

    @Column(name = "calificacionResena", nullable = false)
    private int calificacionResena;

    @Column(name = "detalleResena", length = 200, nullable = true)
    private String detalleResena;

    @Column(name = "exactitudPrecioResena", nullable = true)
    private boolean exactitudPrecioResena;

    @CreationTimestamp
    @Column(name = "createdAtResena", nullable = false, updatable = false)
    private LocalDateTime createdAtResena;

    @UpdateTimestamp
    @Column(name = "updatedAtResena",nullable = false)
    private LocalDateTime updatedAtResena;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "idtipoResena")
    private TipoResena tipoResena;


    public Resena() {
    }

    public Resena(int idResena, int calificacionResena, String detalleResena, boolean exactitudPrecioResena, LocalDateTime createdAtResena, LocalDateTime updatedAtResena, Usuario usuario, Tienda tienda, TipoResena tipoResena) {
        this.idResena = idResena;
        this.calificacionResena = calificacionResena;
        this.detalleResena = detalleResena;
        this.exactitudPrecioResena = exactitudPrecioResena;
        this.usuario = usuario;
        this.tienda = tienda;
        this.tipoResena = tipoResena;
    }

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getCalificacionResena() {
        return calificacionResena;
    }

    public void setCalificacionResena(int calificacionResena) {
        this.calificacionResena = calificacionResena;
    }

    public String getDetalleResena() {
        return detalleResena;
    }

    public void setDetalleResena(String detalleResena) {
        this.detalleResena = detalleResena;
    }

    public boolean isExactitudPrecioResena() {
        return exactitudPrecioResena;
    }

    public void setExactitudPrecioResena(boolean exactitudPrecioResena) {
        this.exactitudPrecioResena = exactitudPrecioResena;
    }

    public LocalDateTime getCreatedAtResena() {
        return createdAtResena;
    }

    public void setCreatedAtResena(LocalDateTime createdAtResena) {
        this.createdAtResena = createdAtResena;
    }

    public LocalDateTime getUpdatedAtResena() {
        return updatedAtResena;
    }

    public void setUpdatedAtResena(LocalDateTime updatedAtResena) {
        this.updatedAtResena = updatedAtResena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public TipoResena getTipoResena() {
        return tipoResena;
    }

    public void setTipoResena(TipoResena tipoResena) {
        this.tipoResena = tipoResena;
    }
}