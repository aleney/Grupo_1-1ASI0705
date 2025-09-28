package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.UbicacionTienda;

import java.util.List;

@Repository
public interface IUbicacionTiendaRepository extends JpaRepository<UbicacionTienda,Integer> {
    @Query("SELECT u FROM UbicacionTienda u WHERE u.direccionUbicacionTienda LIKE %:direccion%")
    List<UbicacionTienda> buscarPorDireccion(@Param("direccion") String direccion);

    @Query("SELECT u FROM UbicacionTienda u WHERE u.distrito.nombreDistrito LIKE %:nombreDistrito%")
    List<UbicacionTienda> buscarPorDistrito(@Param("nombreDistrito") String nombreDistrito);
}
