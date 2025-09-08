package pe.edu.pe.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.bestprice.entities.LineaTiendas;


@Repository
public interface ILineaTiendasRepository extends JpaRepository<LineaTiendas, Integer>{
}
