package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.bestprice.entities.Canasta;

import java.util.List;

public interface ICanastaRepository extends JpaRepository<Canasta, Integer> {

    @Query("SELECT c FROM Canasta c WHERE c.nombreCanasta = :nombreCanasta")
    Canasta findByNombreCanasta(@Param("nombreCanasta") String nombreCanasta);

    @Query("SELECT c FROM Canasta c WHERE c.usuarioCanasta = :usuarioCanasta")
    List<Canasta> findByUsuarioCanasta(@Param("usuarioCanasta") String usuarioCanasta);

    @Query("SELECT c FROM Canasta c ORDER BY c.nombreCanasta ASC")
    List<Canasta> findAllOrderedByNombreCanasta();

    @Query("SELECT COUNT(c) FROM Canasta c WHERE c.usuarioCanasta = :usuarioCanasta")
    long countByUsuarioCanasta(@Param("usuarioCanasta") String usuarioCanasta);

    @Query("SELECT c FROM Canasta c WHERE c.createdACanasta BETWEEN :fechaInicio AND :fechaFin")
    List<Canasta> findByFechaCreacionBetween(@Param("fechaInicio") String fechaInicio,
                                             @Param("fechaFin") String fechaFin);

    @Query("SELECT c FROM Canasta c WHERE c.usuarioCanasta = :usuarioCanasta ORDER BY c.createdACanasta DESC")
    Canasta findTopByUsuarioCanastaOrderByCreatedACanastaDesc(@Param("usuarioCanasta") String usuarioCanasta);
}