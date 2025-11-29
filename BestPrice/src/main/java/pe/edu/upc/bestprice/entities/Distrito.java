package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "Distrito")
public class Distrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDistrito;

    @Column(name = "nombreDistrito", length = 50, nullable = false)
    private String nombreDistrito;

    @Column(name = "descripcionDistrito", length = 450, nullable = false)
    private String descripcionDistrito;

    @Column(name = "longitudDistrito", precision = 10, scale = 6, nullable = false)
    private BigDecimal longitudDistrito;

    @Column(name = "latitudDistrito", precision = 10, scale = 6, nullable = false)
    private BigDecimal latitudDistrito;

    @CreationTimestamp
    @Column(name = "createdAtDistrito", nullable = true, updatable = false)
    private LocalDateTime createdAtDistrito;

    public Distrito() {
    }

    public Distrito(int idDistrito, String nombreDistrito, String descripcionDistrito, BigDecimal longitudDistrito, BigDecimal latitudDistrito) {
        this.idDistrito = idDistrito;
        this.nombreDistrito = nombreDistrito;
        this.descripcionDistrito = descripcionDistrito;
        this.longitudDistrito = longitudDistrito;
        this.latitudDistrito = latitudDistrito;
    }

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getDescripcionDistrito() {
        return descripcionDistrito;
    }

    public void setDescripcionDistrito(String descripcionDistrito) {
        this.descripcionDistrito = descripcionDistrito;
    }

    public BigDecimal getLongitudDistrito() {
        return longitudDistrito;
    }

    public void setLongitudDistrito(BigDecimal longitudDistrito) {
        this.longitudDistrito = longitudDistrito;
    }

    public BigDecimal getLatitudDistrito() {
        return latitudDistrito;
    }

    public void setLatitudDistrito(BigDecimal latitudDistrito) {
        this.latitudDistrito = latitudDistrito;
    }

    public LocalDateTime getCreatedAtDistrito() {
        return createdAtDistrito;
    }

    public void setCreatedAtDistrito(LocalDateTime createdAtDistrito) {
        this.createdAtDistrito = createdAtDistrito;
    }
}
