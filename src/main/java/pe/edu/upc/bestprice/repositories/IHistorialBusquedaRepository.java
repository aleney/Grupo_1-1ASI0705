package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;

import java.util.List;

public interface IHistorialBusquedaRepository extends JpaRepository<HistorialBusqueda, String> {
    void deleteById(int id);

    List<HistorialBusqueda> buscar(Integer id);
}
