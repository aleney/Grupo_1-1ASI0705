package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Usuario;

import java.time.LocalDateTime;

public class ResenaDTOList {
    private int idResena;
    private String nombre;
    private int calificacionResena;
    private String detalleResena;
    private boolean exactitudPrecioResena;
    private LocalDateTime createdAtResena;
    private LocalDateTime updatedAtResena;

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getCalificacionResena() {
        return calificacionResena;
    }

    public void setCalificacionResena(int calificacionResena) {
        this.calificacionResena = calificacionResena;
    }

    public String getDetalleResena() {
        return detalleResena;
    }

    public void setDetalleResena(String detalleResena) {
        this.detalleResena = detalleResena;
    }

    public boolean isExactitudPrecioResena() {
        return exactitudPrecioResena;
    }

    public void setExactitudPrecioResena(boolean exactitudPrecioResena) {
        this.exactitudPrecioResena = exactitudPrecioResena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getCreatedAtResena() {
        return createdAtResena;
    }

    public void setCreatedAtResena(LocalDateTime createdAtResena) {
        this.createdAtResena = createdAtResena;
    }

    public LocalDateTime getUpdatedAtResena() {
        return updatedAtResena;
    }

    public void setUpdatedAtResena(LocalDateTime updatedAtResena) {
        this.updatedAtResena = updatedAtResena;
    }
}