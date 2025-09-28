package pe.edu.upc.BestPrice.servicesinterfaces;

import pe.edu.upc.BestPrice.entities.CategoriaProducto;

import java.util.List;

public interface ICategoriaProductoService {

    public List<CategoriaProducto> listarCategoriaProducto();
    public void insertarCateProduct(CategoriaProducto catePro);
    public CategoriaProducto listId(int id);
    public void update(CategoriaProducto catePro);
    public void delete(int id);
}
