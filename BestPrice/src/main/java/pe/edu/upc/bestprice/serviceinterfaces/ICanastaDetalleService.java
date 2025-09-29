package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleService {
    public void insert(CanastaDetalle cd);

    public default List<CanastaDetalle> buscarService(String usuario) {
        return null;
    }

}
