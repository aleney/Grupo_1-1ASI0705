package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.LineaTiendas;

import java.util.List;


@Repository
public interface ILineaTiendasRepository extends JpaRepository<LineaTiendas, Integer>{
    @Query("Select lt from LineaTiendas lt WHERE lt.nombreLineaTiendas like %:nombre%")
    public List<LineaTiendas> buscar(@Param("nombre") String nombre);
}
