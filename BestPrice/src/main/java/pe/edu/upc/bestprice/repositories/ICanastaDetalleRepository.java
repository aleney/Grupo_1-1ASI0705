package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleRepository extends JpaRepository<CanastaDetalle, Integer> {

    // Buscar CanastaDetalle por ID
    @Query("SELECT cd FROM CanastaDetalle cd WHERE cd.idCanastaDetalle = :idCanastaDetalle")
    CanastaDetalle findByIdCanastaDetalle(@Param("idCanastaDetalle") Integer idCanastaDetalle);

    // Buscar CanastaDetalle por Canasta ID
    @Query("SELECT cd FROM CanastaDetalle cd WHERE cd.canastaCanastaDetalle = :canastaId")
    List<CanastaDetalle> findByCanastaId(@Param("canastaId") int canastaId);

    // Buscar CanastaDetalle por Producto ID
    @Query("SELECT cd FROM CanastaDetalle cd WHERE cd.productoCanastaDetalle = :productoId")
    List<CanastaDetalle> findByProductoId(@Param("productoId") int productoId);

    // Buscar todos los CanastaDetalle asociados a una Canasta, ordenados por cantidad
    @Query("SELECT cd FROM CanastaDetalle cd WHERE cd.canastaCanastaDetalle = :canastaId ORDER BY cd.cantidadCanastaDetalle DESC")
    List<CanastaDetalle> findAllByCanastaIdOrderedByCantidad(@Param("canastaId") int canastaId);

    // Contar la cantidad de detalles asociados a una Canasta
    @Query("SELECT COUNT(cd) FROM CanastaDetalle cd WHERE cd.canastaCanastaDetalle = :canastaId")
    long countByCanastaId(@Param("canastaId") int canastaId);

    // Obtener los CanastaDetalle por un rango de cantidades
    @Query("SELECT cd FROM CanastaDetalle cd WHERE cd.cantidadCanastaDetalle BETWEEN :cantidadMin AND :cantidadMax")
    List<CanastaDetalle> findByCantidadBetween(@Param("cantidadMin") int cantidadMin,
                                               @Param("cantidadMax") int cantidadMax);
}
