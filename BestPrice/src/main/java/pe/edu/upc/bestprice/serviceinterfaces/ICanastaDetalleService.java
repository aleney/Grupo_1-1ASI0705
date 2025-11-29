package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleService {
    public List<CanastaDetalle> list();
    public void insert(CanastaDetalle cd);
    public CanastaDetalle listId(int id);
    public void delete(int id);
    public void edit(CanastaDetalle cd);

}

