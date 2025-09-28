package pe.edu.upc.BestPrice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.BestPrice.entities.Tiendas;

@Repository
public interface ITiendasRepository extends JpaRepository<Tiendas,Integer> {
}
