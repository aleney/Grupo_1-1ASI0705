package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.HistorialPrecio;

import java.time.LocalDate;
import java.util.List;

public interface IHistorialPrecioService {
    List<HistorialPrecio> list();
    void insert(HistorialPrecio hp);
    HistorialPrecio listId(int id);
    void delete(int id);
    void edit(HistorialPrecio hp);
    List<HistorialPrecio> buscarPorProducto(int idProducto);
    List<HistorialPrecio> buscarPorFecha(LocalDate fecha);
}
