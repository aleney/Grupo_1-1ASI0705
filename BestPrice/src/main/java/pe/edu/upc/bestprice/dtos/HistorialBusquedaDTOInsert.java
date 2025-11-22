package pe.edu.upc.bestprice.dtos;

// import java.time.LocalDateTime;

public class HistorialBusquedaDTOInsert {
    // La fecha NO es necesaria aquí debido a @CreationTimestamp en la entidad.
    // private LocalDateTime fechabusqueHistorialBusqueda;

    private int productoidHistoriaBusqueda;
    private int usuarioidHistoriaBusqueda;

    public HistorialBusquedaDTOInsert() {
    }

    public HistorialBusquedaDTOInsert(int productoidHistoriaBusqueda, int usuarioidHistoriaBusqueda) {
        this.productoidHistoriaBusqueda = productoidHistoriaBusqueda;
        this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda;
    }

    public int getProductoidHistoriaBusqueda() { return productoidHistoriaBusqueda; }
    public void setProductoidHistoriaBusqueda(int productoidHistoriaBusqueda) { this.productoidHistoriaBusqueda = productoidHistoriaBusqueda; }
    public int getUsuarioidHistoriaBusqueda() { return usuarioidHistoriaBusqueda; }
    public void setUsuarioidHistoriaBusqueda(int usuarioidHistoriaBusqueda) { this.usuarioidHistoriaBusqueda = usuarioidHistoriaBusqueda; }
}