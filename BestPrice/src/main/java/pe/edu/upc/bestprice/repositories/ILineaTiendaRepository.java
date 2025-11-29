package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.LineaTienda;

import java.util.List;


@Repository
public interface ILineaTiendaRepository extends JpaRepository<LineaTienda, Integer>{
    @Query("Select lt from LineaTienda lt WHERE lt.nombreLineaTienda like %:nombre%")
    public List<LineaTienda> buscar(@Param("nombre") String nombre);

    @Query(value = "SELECT \n" +
            "    id_linea_tienda,\n" +
            "    nombre_linea_tienda,\n" +
            "    detalle_linea_tienda,\n" +
            "    created_at_linea_tienda,\n" +
            "    updated_at_linea_tienda\n" +
            "FROM linea_tienda\n" +
            "WHERE created_at_linea_tienda BETWEEN '2025-01-01' AND '2025-12-31'", nativeQuery = true)
    public List<String[]> TiendasCreadasEn2025();
}
