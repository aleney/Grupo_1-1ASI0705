package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.HistorialBusqueda;

import java.util.List;

public interface IHistorialBusquedaService {

    List<HistorialBusqueda> getAllHistorialBusqueda();
    HistorialBusqueda getHistorialBusquedaById(int id);
    HistorialBusqueda createHistorialBusqueda(HistorialBusqueda historialBusqueda);
    void updateHistorialBusqueda(HistorialBusqueda historialBusqueda);
    void deleteHistorialBusqueda(int id);
}
