package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.LineaTienda;

import java.util.List;


@Repository
public interface ILineaTiendaRepository extends JpaRepository<LineaTienda, Integer>{

}
