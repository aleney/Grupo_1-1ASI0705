package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.TipoTienda;

import java.util.List;

public interface ITipoTiendaService {

    public List<TipoTienda> listarTipoTiendas();
    public void insert(TipoTienda tipoTienda);
    public TipoTienda listarIdTipoTienda(int id);
}
