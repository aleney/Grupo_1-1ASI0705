package pe.edu.upc.bestprice.servicesinterfaces;

import pe.edu.upc.bestprice.entities.CategoriaProducto;

import java.util.List;

public interface ICategoriaProductoService {

    public List<CategoriaProducto> listarCategoriaProducto();
    public void insertarCateProduct(CategoriaProducto catePro);
    public CategoriaProducto listId(int id);
    public void update(CategoriaProducto catePro);
    public void delete(int id);
}
