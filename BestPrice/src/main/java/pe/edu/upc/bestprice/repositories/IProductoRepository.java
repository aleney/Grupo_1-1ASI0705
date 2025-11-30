package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {
}
