package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.upc.bestprice.entities.TipoResena;

import java.util.List;

public interface ITipoResenaRepository extends JpaRepository<TipoResena, Integer> {

    @Query("SELECT t FROM TipoResena t WHERE t.tiporeseTipoResena = :tiporeseTipoResena")
    TipoResena findByTipoResena(@Param("tiporeseTipoResena") String tiporeseTipoResena);

    @Query("SELECT t FROM TipoResena t ORDER BY t.tiporeseTipoResena ASC")
    List<TipoResena> findAllOrderedByName();

    long countByTiporeseTipoResena(String tiporeseTipoResena);
}