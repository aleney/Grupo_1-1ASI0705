package pe.edu.pe.bestprice.dtos;

import pe.edu.pe.bestprice.entities.Producto;
import java.util.List;

public class CategoriaProductoDTO {

    private int idCategoriaProducto;
    private String nombreCategoriaProducto;

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
}
