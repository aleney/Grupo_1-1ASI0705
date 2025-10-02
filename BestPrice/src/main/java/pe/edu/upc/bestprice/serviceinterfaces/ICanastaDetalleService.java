package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleService {
    public List<CanastaDetalle> buscarService(String nombre);
    public void insert(CanastaDetalle cd);

    List<CanastaDetalle> list();

    CanastaDetalle listId(String id);

    public void edit(CanastaDetalle cd);
}
