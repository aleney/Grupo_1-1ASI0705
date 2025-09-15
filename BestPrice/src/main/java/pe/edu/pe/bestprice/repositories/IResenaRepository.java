package pe.edu.pe.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.bestprice.entities.Resena;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer>{
}
