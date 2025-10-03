package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Tiendas;

import java.util.List;

public interface ITiendasService {

    public List<Tiendas> listarTiendas();
    public void insert (Tiendas t);
    public Tiendas listarIdTiendas(int id);
    public void delete(int id);
    public void update(Tiendas t);

}
