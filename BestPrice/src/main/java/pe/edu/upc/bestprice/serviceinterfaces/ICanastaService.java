package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Canasta;

import java.util.List;

public interface ICanastaService {
    public List<Canasta> list();
    public void insert(Canasta c);
    public Canasta listId(int id);
    public void delete(int id);
    public void edit(Canasta c);

   public List<Canasta> buscarService(String usuario);
}
