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

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "idCanasta")
    private Canasta canasta;

    public CanastaDetalle() {
    }

    public CanastaDetalle(Integer idCanastaDetalle, int cantidadCanastaDetalle, int productoCanastaDetalle, int canastaCanastaDetalle, Producto producto, Canasta canasta) {
        this.idCanastaDetalle = idCanastaDetalle;
        this.cantidadCanastaDetalle = cantidadCanastaDetalle;
        this.producto = producto;
        this.canasta = canasta;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Canasta getCanasta() {
        return canasta;
    }

    public void setCanasta(Canasta canasta) {
        this.canasta = canasta;
    }
}
