package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Tienda")
public class Tiendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTiendas;
    @Column(name="nombreTienda", nullable = false, length = 50)
    private String nombreTienda;
    @Column(name="descripcionTienda", nullable = false, length = 250)
    private String descripcionTienda;
    @Column(name="numeroTelefono", nullable = false, length = 9)
    private String numeroTelefono;
    @Column(name="estadoTienda", nullable = false)
    private boolean estadoTienda;
    @Column(name="fechaTienda", nullable = false, length = 13)
    private LocalDate fechaTienda;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoTienda")
    private TipoTienda tipoTienda;

    @OneToMany
    @JoinColumn(name="idProducto")
    private List<Producto> productosTienda;

    public Tiendas() {
    }

    public Tiendas(int idTiendas, String nombreTienda, String descripcionTienda, String numeroTelefono, boolean estadoTienda, LocalDate fechaTienda, TipoTienda tipoTienda, List<Producto> productosTienda) {
        this.idTiendas = idTiendas;
        this.nombreTienda = nombreTienda;
        this.descripcionTienda = descripcionTienda;
        this.numeroTelefono = numeroTelefono;
        this.estadoTienda = estadoTienda;
        this.fechaTienda = fechaTienda;
        this.tipoTienda = tipoTienda;
        this.productosTienda = productosTienda;
    }

    public int getIdTiendas() {
        return idTiendas;
    }

    public void setIdTiendas(int idTiendas) {
        this.idTiendas = idTiendas;
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
