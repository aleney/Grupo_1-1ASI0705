package pe.edu.pe.bestprice.serviceinterfaces;

import pe.edu.pe.bestprice.entities.UbicacionTienda;

import java.util.List;

public interface IUbicacionTiendaService {
    List<UbicacionTienda> list();
    void insert(UbicacionTienda u);
    UbicacionTienda listId(int id);
    void delete(int id);
    void edit(UbicacionTienda u);
}
