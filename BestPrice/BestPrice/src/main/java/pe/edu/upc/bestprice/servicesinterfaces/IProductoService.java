package pe.edu.upc.bestprice.servicesinterfaces;


import pe.edu.upc.bestprice.entities.Producto;

import java.util.List;

public interface IProductoService {

    public List<Producto> List();
    public void insert (Producto p);
    public Producto listId(int id);

}
