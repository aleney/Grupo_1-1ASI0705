package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.OfertasProducto;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IOfertasProductoRepository extends JpaRepository<OfertasProducto,Integer> {
    @Query("SELECT o FROM OfertasProducto o " +
            "WHERE o.producto.idProducto = :idProducto " +
            "AND o.fechainicioOfertasProducto <= :fecha " +
            "AND o.fechafinOfertasProducto >= :fecha")
    List<OfertasProducto> buscarPorProductoYFecha(@Param("idProducto") int idProducto,
                                                  @Param("fecha") LocalDate fecha);

    @Query("SELECT o FROM OfertasProducto o " +
            "WHERE o.producto.idProducto = :idProducto " +
            "AND o.fechainicioOfertasProducto <= :fechaFin " +
            "AND o.fechafinOfertasProducto >= :fechaInicio")
    List<OfertasProducto> buscarPorProductoYRangoFechas(@Param("idProducto") int idProducto,
                                                        @Param("fechaInicio") LocalDate fechaInicio,
                                                        @Param("fechaFin") LocalDate fechaFin);
}