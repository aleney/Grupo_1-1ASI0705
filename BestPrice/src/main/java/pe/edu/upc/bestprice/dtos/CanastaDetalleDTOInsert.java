package pe.edu.upc.bestprice.dtos;

public class CanastaDetalleDTOInsert {
    private int cantidadCanastaDetalle;
    private int productoCanastaDetalle;
    private int canastaCanastaDetalle;

    public CanastaDetalleDTOInsert() {
    }

    public CanastaDetalleDTOInsert(int cantidadCanastaDetalle, int productoCanastaDetalle, int canastaCanastaDetalle) {
        this.cantidadCanastaDetalle = cantidadCanastaDetalle;
        this.productoCanastaDetalle = productoCanastaDetalle;
        this.canastaCanastaDetalle = canastaCanastaDetalle;
    }

    public int getCantidadCanastaDetalle() {
        return cantidadCanastaDetalle;
    }

    public void setCantidadCanastaDetalle(int cantidadCanastaDetalle) {
        this.cantidadCanastaDetalle = cantidadCanastaDetalle;
    }

    public int getProductoCanastaDetalle() {
        return productoCanastaDetalle;
    }

    public void setProductoCanastaDetalle(int productoCanastaDetalle) {
        this.productoCanastaDetalle = productoCanastaDetalle;
    }

    public int getCanastaCanastaDetalle() {
        return canastaCanastaDetalle;
    }

    public void setCanastaCanastaDetalle(int canastaCanastaDetalle) {
        this.canastaCanastaDetalle = canastaCanastaDetalle;
    }
}
