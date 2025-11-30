package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Distrito;

import java.util.List;

@Repository
public interface IDistritoRepository extends JpaRepository<Distrito,Integer> {
    @Query("SELECT d FROM Distrito d WHERE d.nombreDistrito LIKE %:nombre%")
    List<Distrito> buscarPorNombre(@Param("nombre") String nombre);
}
