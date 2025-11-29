package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TipoResena;

import java.util.List;

public interface ITipoResenaService {
    List<TipoResena> getAllTipoResena();
    TipoResena getTipoResenaById(int id);
    TipoResena createTipoResena(TipoResena tipoResena);
    void updateTipoResena(TipoResena tipoResena);
    void deleteTipoResena(int id);
}
