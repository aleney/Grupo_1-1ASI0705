package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;

public class LineaTiendaDTO {

    private int idLineaTienda;
    private String nombreLineaTienda;
    private String detalleLineaTienda;
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

    public String getDetalleLineaTienda() {
        return detalleLineaTienda;
    }

    public void setDetalleLineaTienda(String detalleLineaTienda) {
        this.detalleLineaTienda = detalleLineaTienda;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}