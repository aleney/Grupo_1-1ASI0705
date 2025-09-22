package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "LineaTiendas")
public class LineaTiendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLineaTiendas;

    @Column(name = "nombreLineaTiendas", length = 50, nullable = false)
    private String nombreLineaTiendas;

    @Column(name = "descripcionLineaTiendas", length = 450, nullable = true)
    private String descripcionLineaTiendas;

    @Column(name = "createdAtLineaTiendas", nullable = true)
    private LocalDate createdAtLineaTiendas;

    public LineaTiendas() {
    }

    public LineaTiendas(int idLineaTiendas, String nombreLineaTiendas, String descripcionLineaTiendas, LocalDate createdAtLineaTiendas) {
        this.idLineaTiendas = idLineaTiendas;
        this.nombreLineaTiendas = nombreLineaTiendas;
        this.descripcionLineaTiendas = descripcionLineaTiendas;
        this.createdAtLineaTiendas = createdAtLineaTiendas;
    }

    public int getIdLineaTiendas() {
        return idLineaTiendas;
    }

    public void setIdLineaTiendas(int idLineaTiendas) {
        this.idLineaTiendas = idLineaTiendas;
    }

    public String getNombreLineaTiendas() {
        return nombreLineaTiendas;
    }

    public void setNombreLineaTiendas(String nombreLineaTiendas) {
        this.nombreLineaTiendas = nombreLineaTiendas;
    }

    public String getDescripcionLineaTiendas() {
        return descripcionLineaTiendas;
    }

    public void setDescripcionLineaTiendas(String descripcionLineaTiendas) {
        this.descripcionLineaTiendas = descripcionLineaTiendas;
    }

    public LocalDate getCreatedAt() {
        return createdAtLineaTiendas;
    }

    public void setCreatedAt(LocalDate createdAtLineaTiendas) {
        this.createdAtLineaTiendas = createdAtLineaTiendas;
    }
}