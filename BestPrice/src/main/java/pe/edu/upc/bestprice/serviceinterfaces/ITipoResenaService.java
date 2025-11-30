package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.LineaTienda;
import pe.edu.upc.bestprice.entities.TipoResena;

import java.util.List;

public interface ITipoResenaService {
    public List<TipoResena> listarTipoResena();
    public TipoResena ListId(int id);
    public void insert (TipoResena t);
    public void delete(int id);
    public void update(TipoResena t);
}
