package pe.edu.upc.bestprice.servicesinterfaces;

import pe.edu.upc.bestprice.entities.CategoriaProducto;
import pe.edu.upc.bestprice.entities.Producto;

import java.util.List;

public interface ICategoriaProductoService {

    public List<CategoriaProducto> listarCategoriaProducto();
    public void insertarCateProduct (CategoriaProducto cp);
    public CategoriaProducto listId(int id);
    public void delete(int id);
    public void update(CategoriaProducto cp);

}
