package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TipoReseña;

import java.util.List;

public interface ITipoReseñaService {
    public List<TipoReseña> list();
    public void insert(TipoReseña tipo);
}
