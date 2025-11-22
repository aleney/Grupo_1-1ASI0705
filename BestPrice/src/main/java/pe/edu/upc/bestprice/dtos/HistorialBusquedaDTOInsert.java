package pe.edu.upc.bestprice.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HistorialBusquedaDTOInsert {
    private LocalDateTime fechabusqueHistorialBusqueda;

    public HistorialBusquedaDTOInsert() {
    }

    public HistorialBusquedaDTOInsert(LocalDateTime fechabusqueHistorialBusqueda) {
        this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda;
    }

    public LocalDateTime getFechabusqueHistorialBusqueda() {
        return fechabusqueHistorialBusqueda;
    }

    public void setFechabusqueHistorialBusqueda(LocalDateTime fechabusqueHistorialBusqueda) {
        this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda;
    }
}
