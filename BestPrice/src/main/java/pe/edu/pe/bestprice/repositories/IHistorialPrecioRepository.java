package pe.edu.pe.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.pe.bestprice.entities.HistorialPrecio;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IHistorialPrecioRepository extends JpaRepository<HistorialPrecio,Integer> {
    @Query("SELECT h FROM HistorialPrecio h WHERE h.producto.idProducto = :productoId")
    List<HistorialPrecio> buscarPorProducto(@Param("productoId") Integer productoId);

    @Query("SELECT h FROM HistorialPrecio h WHERE h.fechaHistorialPrecio BETWEEN :fechaInicio AND :fechaFin")
    List<HistorialPrecio> buscarPorRangoFechas(@Param("fechaInicio") LocalDate fechaInicio,
                                               @Param("fechaFin") LocalDate fechaFin);
}
