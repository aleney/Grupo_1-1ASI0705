package pe.edu.pe.bestprice.dtos;

import pe.edu.pe.bestprice.entities.Tienda;
import pe.edu.pe.bestprice.entities.TipoResena;
import pe.edu.pe.bestprice.entities.Usuario;

import java.time.LocalDate;

public class ResenaDTOInsert {
    private int idResena;
    private int calificacionResena;
    private String detalleResena;
    private boolean exactitudPrecioResena;
    private LocalDate createdAtResena;
    private Usuario usuario;
    private Tienda tienda;
    private TipoResena tipoResena;

    public int getIdResena() {
        return idResena;
    }

    public void setIdResena(int idResena) {
        this.idResena = idResena;
    }

    public int getCalificacionResena() {
        return calificacionResena;
    }

    public void setCalificacionResena(int calificacionResena) {
        this.calificacionResena = calificacionResena;
    }

    public String getDetalleResena() {
        return detalleResena;
    }

    public void setDetalleResena(String detalleResena) {
        this.detalleResena = detalleResena;
    }

    public boolean isExactitudPrecioResena() {
        return exactitudPrecioResena;
    }

    public void setExactitudPrecioResena(boolean exactitudPrecioResena) {
        this.exactitudPrecioResena = exactitudPrecioResena;
    }

    public LocalDate getCreatedAtResena() {
        return createdAtResena;
    }

    public void setCreatedAtResena(LocalDate createdAtResena) {
        this.createdAtResena = createdAtResena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public TipoResena getTipoResena() {
        return tipoResena;
    }

    public void setTipoResena(TipoResena tipoResena) {
        this.tipoResena = tipoResena;
    }
}
