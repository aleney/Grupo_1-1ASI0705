package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;

public interface IHistorialBusquedaRepository extends JpaRepository<HistorialBusqueda,Integer> {
}
