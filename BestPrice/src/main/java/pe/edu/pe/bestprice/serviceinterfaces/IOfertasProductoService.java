package pe.edu.pe.bestprice.serviceinterfaces;

import pe.edu.pe.bestprice.entities.OfertasProducto;

import java.time.LocalDate;
import java.util.List;

public interface IOfertasProductoService {
    List<OfertasProducto> list();
    void insert(OfertasProducto o);
    OfertasProducto listId(int id);
    void delete(int id);
    void edit(OfertasProducto o);
    List<OfertasProducto> buscarPorProductoYFecha(int idProducto, LocalDate fecha);
    List<OfertasProducto> buscarPorProductoYRangoFechas(int idProducto, LocalDate fechaInicio, LocalDate fechaFin);
}
