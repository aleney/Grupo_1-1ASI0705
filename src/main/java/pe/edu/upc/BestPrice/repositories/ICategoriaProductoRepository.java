package pe.edu.upc.BestPrice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.BestPrice.entities.CategoriaProducto;

@Repository
public interface ICategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
}
