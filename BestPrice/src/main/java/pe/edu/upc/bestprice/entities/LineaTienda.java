package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

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

    @Column(name = "createdAtLineaTienda", nullable = false)
    private LocalDate createdAtLineaTienda;

    public LineaTienda() {
    }

    public LineaTienda(int idLineaTienda, String nombreLineaTienda, String detalleLineaTienda, LocalDate createdAtLineaTienda) {
        this.idLineaTienda = idLineaTienda;
        this.nombreLineaTienda = nombreLineaTienda;
        this.detalleLineaTienda = detalleLineaTienda;
        this.createdAtLineaTienda = createdAtLineaTienda;
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

    public LocalDate getCreatedAt() {
        return createdAtLineaTienda;
    }

    public void setCreatedAt(LocalDate createdAtLineaTienda) {
        this.createdAtLineaTienda = createdAtLineaTienda;
    }
}