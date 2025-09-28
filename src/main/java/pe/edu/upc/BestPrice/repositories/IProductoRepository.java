package pe.edu.upc.BestPrice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.BestPrice.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
