package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Resena;

import java.util.List;

@Repository
public interface IResenaRepository extends JpaRepository<Resena, Integer>{

    @Query(value = "SELECT r.calificacion_resena as calificacion, r.idtipo_resena\n" +
            " FROM resena r\n" +
            " JOIN tipo_resena t ON r.idtipo_resena = t.id_tipo_resena\n" +
            " WHERE t.id_tipo_resena = 1\n" +
            " ORDER BY r.calificacion_resena ASC;", nativeQuery = true)
    public List<String[]> ListarCalificacionPorResena();
}
