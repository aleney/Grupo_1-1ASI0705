package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.HistorialBusqueda;

import java.util.List;

public interface IHistorialBusquedaService {
    public List<HistorialBusqueda> list();
    public void insert(HistorialBusqueda d);
    public HistorialBusqueda listId(int id);
    public void delete(int id);
}
