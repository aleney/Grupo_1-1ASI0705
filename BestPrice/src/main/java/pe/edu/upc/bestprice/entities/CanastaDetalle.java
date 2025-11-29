package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "CanastaDetalle")
public class CanastaDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCanastaDetalle;

    @Column(name = "cantidadCanastaDetalle", nullable = false)
    private int cantidadCanastaDetalle;

    @Column(name = "productoCanastaDetalle", nullable = false)
    private int productoCanastaDetalle;

    @Column(name = "canastaCanastaDetalle", nullable = false)
    private int canastaCanastaDetalle;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idCanasta")
    private Canasta canasta;

    public CanastaDetalle(Producto producto,  Canasta canasta) {
        this.producto = producto;
        this.canasta = canasta;
    }

    public CanastaDetalle() {
    }

    public CanastaDetalle(Integer idCanastaDetalle, int cantidadCanastaDetalle, int productoCanastaDetalle, int canastaCCanastaDetalle) {
        this.idCanastaDetalle = idCanastaDetalle;
        this.cantidadCanastaDetalle = cantidadCanastaDetalle;
        this.productoCanastaDetalle = productoCanastaDetalle;
        this.canastaCanastaDetalle = canastaCCanastaDetalle;
    }

    public Integer getIdCanastaDetalle() {
        return idCanastaDetalle;
    }

    public void setIdCanastaDetalle(Integer idCanastaDetalle) {
        this.idCanastaDetalle = idCanastaDetalle;
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

    public int getCanastaCCanastaDetalle() {
        return canastaCanastaDetalle;
    }

    public void setCanastaCCanastaDetalle(int canastaCCanastaDetalle) {
        this.canastaCanastaDetalle = canastaCCanastaDetalle;
    }
}
