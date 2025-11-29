package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;

import java.time.LocalDateTime;
import java.util.List;

public interface IHistorialBusquedaRepository extends JpaRepository<HistorialBusqueda, Integer> {

    List<HistorialBusqueda> findByUsuarioidHistoriaBusqueda(int usuarioId);

    List<HistorialBusqueda> findByProductoidHistoriaBusqueda(int productoId);

    @Query("SELECT h FROM HistorialBusqueda h " +
            "WHERE h.fechabusqueHistorialBusqueda BETWEEN :fechaInicio AND :fechaFin")
    List<HistorialBusqueda> buscarPorRangoFechas(@Param("fechaInicio") LocalDateTime fechaInicio,
                                                 @Param("fechaFin") LocalDateTime fechaFin);

    List<HistorialBusqueda> findByUsuarioidHistoriaBusquedaAndProductoidHistoriaBusqueda(int usuarioId, int productoId);

    @Query("SELECT h FROM HistorialBusqueda h " +
            "WHERE h.usuarioidHistoriaBusqueda = :usuarioId " +
            "ORDER BY h.fechabusqueHistorialBusqueda DESC")
    HistorialBusqueda buscarMasRecientePorUsuario(@Param("usuarioId") int usuarioId);

    long countByUsuarioidHistoriaBusqueda(int usuarioId);

    long countByProductoidHistoriaBusqueda(int productoId);
}