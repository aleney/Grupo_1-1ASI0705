package pe.edu.upc.BestPrice.servicesinterfaces;
import pe.edu.upc.BestPrice.entities.Producto;
import java.util.List;

public interface IProductoService {

    public List<Producto> List();
    public void insert (Producto p);
    public Producto listId(int id);
    public void update(Producto p);
    public void delete(int id);
}
