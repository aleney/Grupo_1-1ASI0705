package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.TipoTienda;

import java.time.LocalDate;

public class TiendaDTO {

    private int idTienda;
    private String nombreTienda;
    private String descripcionTienda;
    private String numeroTelefono;
    private boolean estadoTienda;
    private LocalDate fechaTienda;
    private TipoTienda tipoTienda;

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getDescripcionTienda() {
        return descripcionTienda;
    }

    public void setDescripcionTienda(String descripcionTienda) {
        this.descripcionTienda = descripcionTienda;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public boolean isEstadoTienda() {
        return estadoTienda;
    }

    public void setEstadoTienda(boolean estadoTienda) {
        this.estadoTienda = estadoTienda;
    }

    public LocalDate getFechaTienda() {
        return fechaTienda;
    }

    public void setFechaTienda(LocalDate fechaTienda) {
        this.fechaTienda = fechaTienda;
    }

    public TipoTienda getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(TipoTienda tipoTienda) {
        this.tipoTienda = tipoTienda;
    }
}
