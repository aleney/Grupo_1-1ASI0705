package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;

public class LineaTiendasDTO {

    private int idLineaTiendas;
    private String nombreLineaTiendas;
    private String descripcionLineaTiendas;
    private LocalDate createdAt;

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
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}