package pe.edu.upc.bestprice.dtos;

public class ResenaDTOList {
    private int idResena;
    private int calificacionResena;
    private String detalleResena;
    private boolean exactitudPrecioResena;

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
}