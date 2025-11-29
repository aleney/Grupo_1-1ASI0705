package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Distrito;
import pe.edu.upc.bestprice.entities.Tienda;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UbicacionTiendaDTO {
    private int idUbicacionTienda;
    private String direccionUbicacionTienda;
    private BigDecimal longitudUbicacionTienda;
    private BigDecimal latitudUbicacionTienda;
    private LocalDateTime createdAtUbicacionTienda;
    private Tienda tienda;
    private Distrito distrito;

    public int getIdUbicacionTienda() {
        return idUbicacionTienda;
    }

    public void setIdUbicacionTienda(int idUbicacionTienda) {
        this.idUbicacionTienda = idUbicacionTienda;
    }

    public String getDireccionUbicacionTienda() {
        return direccionUbicacionTienda;
    }

    public void setDireccionUbicacionTienda(String direccionUbicacionTienda) {
        this.direccionUbicacionTienda = direccionUbicacionTienda;
    }

    public BigDecimal getLongitudUbicacionTienda() {
        return longitudUbicacionTienda;
    }

    public void setLongitudUbicacionTienda(BigDecimal longitudUbicacionTienda) {
        this.longitudUbicacionTienda = longitudUbicacionTienda;
    }

    public BigDecimal getLatitudUbicacionTienda() {
        return latitudUbicacionTienda;
    }

    public void setLatitudUbicacionTienda(BigDecimal latitudUbicacionTienda) {
        this.latitudUbicacionTienda = latitudUbicacionTienda;
    }

    public LocalDateTime getCreatedAtUbicacionTienda() {
        return createdAtUbicacionTienda;
    }

    public void setCreatedAtUbicacionTienda(LocalDateTime createdAtUbicacionTienda) {
        this.createdAtUbicacionTienda = createdAtUbicacionTienda;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
}
