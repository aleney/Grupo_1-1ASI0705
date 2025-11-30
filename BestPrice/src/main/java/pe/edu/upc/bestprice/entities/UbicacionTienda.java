package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "UbicacionTienda")
public class UbicacionTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUbicacionTienda;

    @Column(name = "direccionUbicacionTienda", length = 200, nullable = false)
    private String direccionUbicacionTienda;

    @Column(name = "longitudUbicacionTienda", precision = 10, scale = 6, nullable = false)
    private BigDecimal longitudUbicacionTienda;

    @Column(name = "latitudUbicacionTienda", precision = 10, scale = 6, nullable = false)
    private BigDecimal latitudUbicacionTienda;

    @CreationTimestamp
    @Column(name = "createdAtUbicacionTienda", nullable = true, updatable = false)
    private LocalDateTime createdAtUbicacionTienda;

    @UpdateTimestamp
    @Column(name = "updatedAtUbicacionTienda", nullable = true)
    private LocalDateTime updatedAtUbicacionTienda;

    @ManyToOne
    @JoinColumn(name = "idTienda")
    private Tienda tienda;

    @ManyToOne
    @JoinColumn(name = "idDistrito")
    private Distrito distrito;

    public UbicacionTienda() {
    }

    public UbicacionTienda(int idUbicacionTienda, String direccionUbicacionTienda, BigDecimal longitudUbicacionTienda, BigDecimal latitudUbicacionTienda, LocalDateTime createdAtUbicacionTienda, Tienda tienda, Distrito distrito) {
        this.idUbicacionTienda = idUbicacionTienda;
        this.direccionUbicacionTienda = direccionUbicacionTienda;
        this.longitudUbicacionTienda = longitudUbicacionTienda;
        this.latitudUbicacionTienda = latitudUbicacionTienda;
        this.tienda = tienda;
        this.distrito = distrito;
    }

    public int getIdUbicacionTienda() {
        return idUbicacionTienda;
    }

    public void setIdUbicacionTienda(int idUbicacionTienda) {
        this.idUbicacionTienda = idUbicacionTienda;
    }

    public String getDireccionUbicacionTienda() {
        return direccionUbicacionTienda;
    }

    public void setDireccionUbicacionTienda(String direccionUbicacionTienda) {
        this.direccionUbicacionTienda = direccionUbicacionTienda;
    }

    public BigDecimal getLongitudUbicacionTienda() {
        return longitudUbicacionTienda;
    }

    public void setLongitudUbicacionTienda(BigDecimal longitudUbicacionTienda) {
        this.longitudUbicacionTienda = longitudUbicacionTienda;
    }

    public BigDecimal getLatitudUbicacionTienda() {
        return latitudUbicacionTienda;
    }

    public void setLatitudUbicacionTienda(BigDecimal latitudUbicacionTienda) {
        this.latitudUbicacionTienda = latitudUbicacionTienda;
    }

    public LocalDateTime getCreatedAtUbicacionTienda() {
        return createdAtUbicacionTienda;
    }

    public void setCreatedAtUbicacionTienda(LocalDateTime createdAtUbicacionTienda) {
        this.createdAtUbicacionTienda = createdAtUbicacionTienda;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public LocalDateTime getUpdatedAtUbicacionTienda() {
        return updatedAtUbicacionTienda;
    }

    public void setUpdatedAtUbicacionTienda(LocalDateTime updatedAtUbicacionTienda) {
        this.updatedAtUbicacionTienda = updatedAtUbicacionTienda;
    }
}
