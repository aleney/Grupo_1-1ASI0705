package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.TipoTienda;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TiendaDTOList {

    private int idTienda;
    private String nombreTienda;
    private String detalleTienda;
    private String numeroTelefono;
    private boolean estadoTienda;
    private LocalDateTime createdAtT;
    private LocalDateTime updatedAtT;
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

    public String getDetalleTienda() {
        return detalleTienda;
    }

    public void setDetalleTienda(String detalleTienda) {
        this.detalleTienda = detalleTienda;
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

    public TipoTienda getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(TipoTienda tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public LocalDateTime getCreatedAtT() {
        return createdAtT;
    }

    public void setCreatedAtT(LocalDateTime createdAtT) {
        this.createdAtT = createdAtT;
    }

    public LocalDateTime getUpdatedAtT() {
        return updatedAtT;
    }

    public void setUpdatedAtT(LocalDateTime updatedAtT) {
        this.updatedAtT = updatedAtT;
    }
}

