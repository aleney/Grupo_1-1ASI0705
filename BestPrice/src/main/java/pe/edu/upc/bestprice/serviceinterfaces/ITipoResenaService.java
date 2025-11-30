package pe.edu.upc.bestprice.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.bestprice.entities.TipoResena;

import java.util.List;

public interface ITipoResenaService {
    public List<TipoResena>getAllTipoResena();
    public void createTipoResena(TipoResena tr);
    public TipoResena getTipoResenaById(int id);
    public void updateTipoResena(TipoResena tr);
    public void deleteTipoResena(int id);
    public List<TipoResena> findByTipoResena(String nombre);
    public List<TipoResena> findAllOrderedByName();


}
