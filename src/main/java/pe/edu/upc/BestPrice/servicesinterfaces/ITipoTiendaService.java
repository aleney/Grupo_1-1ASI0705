package pe.edu.upc.BestPrice.servicesinterfaces;

import pe.edu.upc.BestPrice.entities.TipoTienda;

import java.util.List;

public interface ITipoTiendaService {

    public List<TipoTienda> listarTipoTiendas();
    public void insert(TipoTienda tipoTienda);
    public TipoTienda listarIdTipoTienda(int id);
    public void update(TipoTienda tipoTienda);
    public void delete(int id);
}
