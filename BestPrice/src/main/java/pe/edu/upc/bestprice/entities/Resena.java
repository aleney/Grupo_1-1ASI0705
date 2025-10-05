package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name = "createdAtResena", nullable = false)
    private LocalDate createdAtResena;

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

    public Resena(int idResena, int calificacionResena, String detalleResena, boolean exactitudPrecioResena, LocalDate createdAtResena) {
        this.idResena = idResena;
        this.calificacionResena = calificacionResena;
        this.detalleResena = detalleResena;
        this.exactitudPrecioResena = exactitudPrecioResena;
        this.createdAtResena = createdAtResena;
    }

    public Resena(Usuario usuario, Tienda tienda, TipoResena tipoResena) {
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

    public LocalDate getCreatedAtResena() {
        return createdAtResena;
    }

    public void setCreatedAtResena(LocalDate createdAtResena) {
        this.createdAtResena = createdAtResena;
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