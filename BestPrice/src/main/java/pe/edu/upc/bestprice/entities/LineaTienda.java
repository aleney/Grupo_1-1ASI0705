package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "LineaTienda")
public class LineaTienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLineaTienda;

    @Column(name = "nombreLineaTienda", length = 50, nullable = false)
    private String nombreLineaTienda;

    @Column(name = "detalleLineaTienda", length = 450, nullable = true)
    private String detalleLineaTienda;

    @CreationTimestamp
    @Column(name = "createdAtLineaTienda", nullable = true, updatable = false)
    private LocalDateTime createdAtLineaTienda;

    @UpdateTimestamp
    @Column(name = "updatedAtLineaTienda", nullable = true)
    private LocalDateTime updatedAtLineaTienda;

    public LineaTienda() {
    }

    public LineaTienda(int idLineaTienda, String nombreLineaTienda, String detalleLineaTienda) {
        this.idLineaTienda = idLineaTienda;
        this.nombreLineaTienda = nombreLineaTienda;
        this.detalleLineaTienda = detalleLineaTienda;
    }

    public int getIdLineaTienda() {
        return idLineaTienda;
    }

    public void setIdLineaTienda(int idLineaTienda) {
        this.idLineaTienda = idLineaTienda;
    }

    public String getNombreLineaTienda() {
        return nombreLineaTienda;
    }

    public void setNombreLineaTienda(String nombreLineaTienda) {
        this.nombreLineaTienda = nombreLineaTienda;
    }

    public String getDetalleLineaTienda() {
        return detalleLineaTienda;
    }

    public void setDetalleLineaTienda(String detalleLineaTienda) {
        this.detalleLineaTienda = detalleLineaTienda;
    }

    public LocalDateTime getCreatedAtLineaTienda() {
        return createdAtLineaTienda;
    }

    public void setCreatedAtLineaTienda(LocalDateTime createdAtLineaTienda) {
        this.createdAtLineaTienda = createdAtLineaTienda;
    }

    public LocalDateTime getUpdatedAtLineaTienda() {
        return updatedAtLineaTienda;
    }

    public void setUpdatedAtLineaTienda(LocalDateTime updatedAtLineaTienda) {
        this.updatedAtLineaTienda = updatedAtLineaTienda;
    }
}