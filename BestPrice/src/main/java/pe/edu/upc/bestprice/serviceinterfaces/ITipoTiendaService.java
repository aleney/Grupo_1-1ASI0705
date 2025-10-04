package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TipoTienda;

import java.util.List;

public interface ITipoTiendaService {

    public List<TipoTienda> listarTipoTienda();
    public void insert (TipoTienda tt);
    public TipoTienda listarIdTipoTienda(int id);
    public void delete(int id);
    public void update(TipoTienda tt);

}
