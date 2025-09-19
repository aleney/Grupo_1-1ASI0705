package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.HistorialBusqueda;

import java.util.List;
import java.util.Optional;

public interface IHistorialBusquedaService {
    public List<HistorialBusqueda> listarTodos();
    public Optional<HistorialBusqueda> buscarPorId(String id);
    public HistorialBusqueda guardar(HistorialBusqueda historialBusqueda);
    public HistorialBusqueda actualizar(String id, HistorialBusqueda historialBusquedaRequest);
    public void eliminar(String id);
    public List<HistorialBusqueda>list();
    public void insert(HistorialBusqueda historial);
    public HistorialBusqueda listId(int id);
    public void delete(int id);
    public void edit(HistorialBusqueda historial);
    public List<HistorialBusqueda> buscarService(Integer id);
}
