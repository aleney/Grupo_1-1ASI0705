package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class LineaTiendaDTOTiendasAnio {
    private String nombreLineaTienda;
    private LocalDateTime createdAtLineaTienda;

    public String getNombreLineaTienda() {
        return nombreLineaTienda;
    }

    public void setNombreLineaTienda(String nombreLineaTienda) {
        this.nombreLineaTienda = nombreLineaTienda;
    }

    public LocalDateTime getCreatedAtLineaTienda() {
        return createdAtLineaTienda;
    }

    public void setCreatedAtLineaTienda(LocalDateTime createdAtLineaTienda) {
        this.createdAtLineaTienda = createdAtLineaTienda;
    }
}
