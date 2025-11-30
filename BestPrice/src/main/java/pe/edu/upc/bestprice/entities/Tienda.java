package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
    @Column(name="nombreTienda", nullable = false, length = 50)
    private String nombreTienda;
    @Column(name="detalleTienda", nullable = true, length = 250)
    private String detalleTienda;
    @Column(name="numeroTelefono", nullable = true, length = 9)
    private String numeroTelefono;
    @Column(name="estadoTienda", nullable = false)
    private boolean estadoTienda;

    @CreationTimestamp
    @Column(name="createdAtT", nullable = true, updatable = false)
    private LocalDateTime createdAtT;

    @UpdateTimestamp
    @Column(name="updatedAtT",nullable = true)
    private LocalDateTime updatedAtT;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTipoTienda")
    private TipoTienda tipoTienda;

    @ManyToOne
    @JoinColumn(name="idlineTiend")
    private LineaTienda lineaTienda;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombreTienda, String detalleTienda, String numeroTelefono, boolean estadoTienda, LocalDate fechaTienda, LocalDateTime createdAtT, LocalDateTime updatedAtT, Usuario usuario, TipoTienda tipoTienda, LineaTienda lineaTienda) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
        this.detalleTienda = detalleTienda;
        this.numeroTelefono = numeroTelefono;
        this.estadoTienda = estadoTienda;
        this.usuario = usuario;
        this.tipoTienda = tipoTienda;
        this.lineaTienda = lineaTienda;
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

    public String getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(String detalleTienda) {
        this.detalleTienda = detalleTienda;
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

    public LocalDateTime getCreatedAtT() {
        return createdAtT;
    }

    public void setCreatedAtT(LocalDateTime createdAtT) {
        this.createdAtT = createdAtT;
    }

    public LocalDateTime getUpdatedAtT() {
        return updatedAtT;
    }

    public void setUpdatedAtT(LocalDateTime updatedAtT) {
        this.updatedAtT = updatedAtT;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TipoTienda getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(TipoTienda tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public LineaTienda getLineaTienda() {
        return lineaTienda;
    }

    public void setLineaTienda(LineaTienda lineaTienda) {
        this.lineaTienda = lineaTienda;
    }
}