package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;

public class LineaTiendaDTOTiendaAnio {
    private String nombreLineaTienda;
    private LocalDate createdAt;

    public String getNombreLineaTienda() {
        return nombreLineaTienda;
    }

    public void setNombreLineaTienda(String nombreLineaTienda) {
        this.nombreLineaTienda = nombreLineaTienda;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}