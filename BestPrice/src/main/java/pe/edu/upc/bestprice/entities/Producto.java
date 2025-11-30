package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "nombreProducto", nullable = false, length = 25)
    private String nombreProducto;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto ) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
