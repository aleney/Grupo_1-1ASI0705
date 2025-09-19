package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaService {
    public List<CanastaDetalle> list();
    public void insert(Canasta c);
    public void insert(CanastaDetalle cd);
    public Canasta listId(int id);
    public void delete(int id);
    public void edit(Canasta c);
    public void edit(CanastaDetalle cd);
    public List<Canasta> buscarService(String usuario);
}
