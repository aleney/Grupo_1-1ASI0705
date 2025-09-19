package pe.edu.pe.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.bestprice.entities.CategoriaProducto;

@Repository
public interface ICategoriaProductoRepository extends JpaRepository<CategoriaProducto, Integer> {
}
