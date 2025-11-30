package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class LineaTiendaDTOTiendasAnio {
    private int idLineaTienda;
    private String nombreLineaTienda;
    private String detalleLineaTienda;
    private LocalDateTime createdAtLineaTienda;
    private LocalDateTime updatedAtLineaTienda;

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
