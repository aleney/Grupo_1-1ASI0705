package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="CategoriaProducto")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoriaProducto;
    @Column(name="nombreCategoriaProducto", nullable=false, length=50)
    private String nombreCategoriaProducto;

    @OneToMany
    @JoinColumn(name="idProducto")
    private List<Producto> cateproductos;

    public CategoriaProducto() {
    }

    public CategoriaProducto(int idCategoriaProducto, String nombreCategoriaProducto, List<Producto> cateproductos) {
        this.idCategoriaProducto = idCategoriaProducto;
        this.nombreCategoriaProducto = nombreCategoriaProducto;
        this.cateproductos = cateproductos;
    }

    public int getIdCategoriaProducto() {
        return idCategoriaProducto;
    }

    public void setIdCategoriaProducto(int idCategoriaProducto) {
        this.idCategoriaProducto = idCategoriaProducto;
    }

    public String getNombreCategoriaProducto() {
        return nombreCategoriaProducto;
    }

    public void setNombreCategoriaProducto(String nombreCategoriaProducto) {
        this.nombreCategoriaProducto = nombreCategoriaProducto;
    }

    public List<Producto> getCateproductos() {
        return cateproductos;
    }

    public void setCateproductos(List<Producto> cateproductos) {
        this.cateproductos = cateproductos;
    }
}
