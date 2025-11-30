package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Canasta;

import java.util.List;

@Repository
public interface ICanastaRepository extends JpaRepository<Canasta, Integer> {

    @Query(value = "SELECT * " +
            "FROM canasta " +
            "WHERE nombre_canasta = :nombreCanasta", nativeQuery = true)
    public Canasta findByNombreCanasta(@Param("nombreCanasta") String nombreCanasta);

    @Query(value = "SELECT * " +
            "FROM canasta " +
            "WHERE usuario_canasta = :usuarioCanasta", nativeQuery = true)
    public List<Canasta> findByUsuarioCanasta(@Param("usuarioCanasta") String usuarioCanasta);

    @Query(value = "SELECT * " +
            "FROM canasta " +
            "ORDER BY nombre_canasta ASC", nativeQuery = true)
    public List<Canasta> findAllOrderedByNombreCanasta();

    @Query(value = "SELECT COUNT(*) " +
            "FROM canasta " +
            "WHERE usuario_canasta = :usuarioCanasta", nativeQuery = true)
    public long countByUsuarioCanasta(@Param("usuarioCanasta") String usuarioCanasta);

    @Query(value = "SELECT * " +
            "FROM canasta " +
            "WHERE created_at_canasta BETWEEN :fechaInicio AND :fechaFin", nativeQuery = true)
    public List<Canasta> findByFechaCreacionBetween(@Param("fechaInicio") String fechaInicio,
                                                    @Param("fechaFin") String fechaFin);

    @Query(value = "SELECT * " +
            "FROM canasta " +
            "WHERE usuario_canasta = :usuarioCanasta " +
            "ORDER BY created_at_canasta DESC " +
            "LIMIT 1", nativeQuery = true)
    public Canasta findTopByUsuarioCanastaOrderByCreatedACanastaDesc(@Param("usuarioCanasta") String usuarioCanasta);
}
