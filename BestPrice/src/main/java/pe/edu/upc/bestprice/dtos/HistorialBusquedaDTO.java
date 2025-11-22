package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class HistorialBusquedaDTO {
    private int idHistorialBusqueda;
    private LocalDateTime fechabusqueHistorialBusqueda;
    private int productoidHistoriaBusqueda;
    private int usuarioidHistoriaBusqueda;

    // Constructores, Getters y Setters...
    public HistorialBusquedaDTO() {}

    public HistorialBusquedaDTO(int idHistorialBusqueda, LocalDateTime fechabusqueHistorialBusqueda, int productoidHistoriaBusqueda, int usuarioidHistoriaBusqueda) {
        this.idHistorialBusqueda = idHistorialBusqueda;
        this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda;
        this.productoidHistoriaBusqueda = productoidHistoriaBusqueda;
        this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda;
    }

    public int getIdHistorialBusqueda() { return idHistorialBusqueda; }
    public void setIdHistorialBusqueda(int idHistorialBusqueda) { this.idHistorialBusqueda = idHistorialBusqueda; }
    public LocalDateTime getFechabusqueHistorialBusqueda() { return fechabusqueHistorialBusqueda; }
    public void setFechabusqueHistorialBusqueda(LocalDateTime fechabusqueHistorialBusqueda) { this.fechabusqueHistorialBusqueda = fechabusqueHistorialBusqueda; }
    public int getProductoidHistoriaBusqueda() { return productoidHistoriaBusqueda; }
    public void setProductoidHistoriaBusqueda(int productoidHistoriaBusqueda) { this.productoidHistoriaBusqueda = productoidHistoriaBusqueda; }
    public int getUsuarioidHistoriaBusqueda() { return usuarioidHistoriaBusqueda; }
    public void setUsuarioidHistoriaBusqueda(int usuarioidHistoriaBusqueda) { this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda; }
}