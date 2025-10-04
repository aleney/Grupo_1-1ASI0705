package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
    @Column(name="nombreTienda", nullable = false, length = 50)
    private String nombreTienda;
    @Column(name="descripcionTienda", nullable = true, length = 250)
    private String descripcionTienda;
    @Column(name="numeroTelefono", nullable = true, length = 9)
    private String numeroTelefono;
    @Column(name="estadoTienda", nullable = false)
    private boolean estadoTienda;
    @Column(name="fechaTienda", nullable = false, length = 13)
    private LocalDate fechaTienda;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoTienda")
    private TipoTienda tipoTienda;

    @OneToMany
    @JoinColumn(name="idProducto")
    private List<Producto> productosTienda;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombreTienda, String descripcionTienda, String numeroTelefono, boolean estadoTienda, LocalDate fechaTienda, TipoTienda tipoTienda, List<Producto> productosTienda) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.descripcionTienda = descripcionTienda;
        this.numeroTelefono = numeroTelefono;
        this.estadoTienda = estadoTienda;
        this.fechaTienda = fechaTienda;
        this.tipoTienda = tipoTienda;
        this.productosTienda = productosTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDescripcionTienda() {
        return descripcionTienda;
    }

    public void setDescripcionTienda(String descripcionTienda) {
        this.descripcionTienda = descripcionTienda;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isEstadoTienda() {
        return estadoTienda;
    }

    public void setEstadoTienda(boolean estadoTienda) {
        this.estadoTienda = estadoTienda;
    }

    public LocalDate getFechaTienda() {
        return fechaTienda;
    }

    public void setFechaTienda(LocalDate fechaTienda) {
        this.fechaTienda = fechaTienda;
    }

    public TipoTienda getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(TipoTienda tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public List<Producto> getProductosTienda() {
        return productosTienda;
    }

    public void setProductosTienda(List<Producto> productosTienda) {
        this.productosTienda = productosTienda;
    }
}