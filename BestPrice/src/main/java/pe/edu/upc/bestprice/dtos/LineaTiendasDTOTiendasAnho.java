package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;

public class LineaTiendasDTOTiendasAnho {
    private String nombreLineaTiendas;
    private LocalDate createdAt;

    public String getNombreLineaTiendas() {
        return nombreLineaTiendas;
    }

    public void setNombreLineaTiendas(String nombreLineaTiendas) {
        this.nombreLineaTiendas = nombreLineaTiendas;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}