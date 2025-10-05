package pe.edu.upc.bestprice.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DistritoDTO {
    private int idDistrito;
    private String nombreDistrito;
    private String detalleDistrito;
    private BigDecimal longitudDistrito;
    private BigDecimal latitudDistrito;
    private Timestamp createdAtDistrito;

    public int getIdDistrito() {
        return idDistrito;
    }

    public void setIdDistrito(int idDistrito) {
        this.idDistrito = idDistrito;
    }

    public String getNombreDistrito() {
        return nombreDistrito;
    }

    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    public String getDetalleDistrito() {
        return detalleDistrito;
    }

    public void setDetalleDistrito(String detalleDistrito) {
        this.detalleDistrito = detalleDistrito;
    }

    public BigDecimal getLongitudDistrito() {
        return longitudDistrito;
    }

    public void setLongitudDistrito(BigDecimal longitudDistrito) {
        this.longitudDistrito = longitudDistrito;
    }

    public BigDecimal getLatitudDistrito() {
        return latitudDistrito;
    }

    public void setLatitudDistrito(BigDecimal latitudDistrito) {
        this.latitudDistrito = latitudDistrito;
    }

    public Timestamp getCreatedAtDistrito() {
        return createdAtDistrito;
    }

    public void setCreatedAtDistrito(Timestamp createdAtDistrito) {
        this.createdAtDistrito = createdAtDistrito;
    }
}
