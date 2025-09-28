package pe.edu.upc.bestprice.servicesinterfaces;

import pe.edu.upc.bestprice.entities.Tiendas;

import java.util.List;

public interface ITiendasService {

    public List<Tiendas> listarTiendas();
    public void insert (Tiendas tiendas);
    public Tiendas listarIdTiendas(int id);

}
