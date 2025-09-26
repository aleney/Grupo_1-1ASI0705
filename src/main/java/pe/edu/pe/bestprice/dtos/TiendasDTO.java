package pe.edu.pe.bestprice.dtos;
import pe.edu.pe.bestprice.entities.Producto;
import pe.edu.pe.bestprice.entities.TipoTienda;

import java.time.LocalDate;
import java.util.List;

public class TiendasDTO {

    private int idTiendas;
    private String nombreTienda;
    private String descripcionTienda;
    private String numeroTelefono;
    private boolean estadoTienda;
    private LocalDate fechaTienda;
    private TipoTienda tipoTienda;

    public int getIdTiendas() {
        return idTiendas;
    }

    public void setIdTiendas(int idTiendas) {
        this.idTiendas = idTiendas;
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
