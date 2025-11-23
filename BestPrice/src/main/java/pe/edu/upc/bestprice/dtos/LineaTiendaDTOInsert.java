package pe.edu.upc.bestprice.dtos;

public class LineaTiendaDTOInsert {
    private int idLineaTienda;
    private String nombreLineaTienda;
    private String detalleLineaTienda;

    public int getIdLineaTienda() {
        return idLineaTienda;
    }

    public void setIdLineaTienda(int idLineaTienda) {
        this.idLineaTienda = idLineaTienda;
    }

    public String getNombreLineaTienda() {
        return nombreLineaTienda;
    }

    public void setNombreLineaTienda(String nombreLineaTienda) {
        this.nombreLineaTienda = nombreLineaTienda;
    }

    public String getDetalleLineaTienda() {
        return detalleLineaTienda;
    }

    public void setDetalleLineaTienda(String detalleLineaTienda) {
        this.detalleLineaTienda = detalleLineaTienda;
    }
}
