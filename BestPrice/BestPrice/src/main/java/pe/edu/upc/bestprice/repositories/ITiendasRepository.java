package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Tiendas;

@Repository
public interface ITiendasRepository extends JpaRepository<Tiendas,Integer> {
}
