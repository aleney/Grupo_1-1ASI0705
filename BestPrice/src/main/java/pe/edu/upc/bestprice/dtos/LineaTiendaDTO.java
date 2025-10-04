package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;

public class LineaTiendaDTO {

    private int idLineaTienda;
    private String nombreLineaTienda;
    private String descripcionLineaTienda;
    private LocalDate createdAt;

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

    public String getDescripcionLineaTienda() {
        return descripcionLineaTienda;
    }

    public void setDescripcionLineaTienda(String descripcionLineaTienda) {
        this.descripcionLineaTienda = descripcionLineaTienda;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}