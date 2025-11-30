package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Distrito;

import java.util.List;

public interface IDistritoService {
    public List<Distrito> list();
    public void insert(Distrito d);
    public Distrito listId(int id);
    public void delete(int id);
    public void edit(Distrito d);
}
