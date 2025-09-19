package pe.edu.pe.bestprice.serviceinterfaces;

import pe.edu.pe.bestprice.entities.Distrito;

import java.util.List;

public interface IDistritoService {
    public List<Distrito> list();
    public void insert(Distrito d);
    public Distrito listId(int id);
    public void delete(int id);
    public void edit(Distrito d);
}
