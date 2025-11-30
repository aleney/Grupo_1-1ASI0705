package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

@Repository
public interface ICanastaDetalleRepository extends JpaRepository<CanastaDetalle, Integer> {

    @Query(value = "SELECT * " +
            "FROM canasta_detalle " +
            "WHERE id_canasta = :canastaId", nativeQuery = true)
    public List<CanastaDetalle> findByCanastaId(@Param("canastaId") int canastaId);

    @Query(value = "SELECT * " +
            "FROM canasta_detalle " +
            "WHERE id_producto = :productoId", nativeQuery = true)
    public List<CanastaDetalle> findByProductoId(@Param("productoId") int productoId);

    @Query(value = "SELECT COUNT(*) " +
            "FROM canasta_detalle " +
            "WHERE id_canasta = :canastaId", nativeQuery = true)
    public int countByCanastaId(@Param("canastaId") int canastaId);

    @Query(value = "SELECT * " +
            "FROM canasta_detalle " +
            "WHERE cantidad_canasta_detalle BETWEEN :cantidadMin AND :cantidadMax", nativeQuery = true)
    public List<CanastaDetalle> findByCantidadBetween(@Param("cantidadMin") int cantidadMin,
                                                      @Param("cantidadMax") int cantidadMax);
}
