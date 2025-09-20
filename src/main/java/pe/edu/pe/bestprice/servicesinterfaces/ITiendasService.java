package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.Tiendas;

import java.util.List;

public interface ITiendasService {

    public List<Tiendas> listarTiendas();
    public void insert (Tiendas tiendas);
    public Tiendas listarIdTiendas(int id);

}
