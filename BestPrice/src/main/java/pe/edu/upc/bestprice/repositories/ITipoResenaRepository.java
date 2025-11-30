package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.TipoResena;

import java.util.List;

@Repository
public interface ITipoResenaRepository extends JpaRepository<TipoResena, Integer> {

    @Query("SELECT t FROM TipoResena t WHERE t.tiporeseTipoResena like %:nombre%")
    public List<TipoResena> findByTipoResena(@Param("tiporeseTipoResena") String nombre);

    @Query(value = "SELECT t FROM TipoResena t ORDER BY t.tiporeseTipoResena ASC", nativeQuery = true)
    public List<TipoResena> findAllOrderedByName();

}