package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

@Repository
public interface ICanastaRepository extends JpaRepository<Canasta,Integer> {

    List<CanastaDetalle> buscar(String usuario);
}
