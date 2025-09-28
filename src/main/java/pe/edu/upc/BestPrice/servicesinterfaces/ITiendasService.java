package pe.edu.upc.BestPrice.servicesinterfaces;

import pe.edu.upc.BestPrice.entities.Tiendas;

import java.util.List;

public interface ITiendasService {

    public List<Tiendas> listarTiendas();
    public void insert (Tiendas tiendas);
    public Tiendas listarIdTiendas(int id);
    public void update(Tiendas tiendas);
    public void delete(int id);

}
