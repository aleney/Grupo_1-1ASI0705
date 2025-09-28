package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.CategoriaProducto;

import java.util.List;

public interface ICategoriaProductoService {

    public List<CategoriaProducto> listarCategoriaProducto();
    public void insertarCateProduct(CategoriaProducto catePro);
    public CategoriaProducto listId(int id);
}
