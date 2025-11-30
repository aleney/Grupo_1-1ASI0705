package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Tienda;

import java.util.List;

public interface ITiendaService {

    public List<Tienda> listarTienda();
    public void insert (Tienda t);
    public Tienda listarIdTienda(int id);
    public void delete(int id);
    public void update(Tienda t);

}
