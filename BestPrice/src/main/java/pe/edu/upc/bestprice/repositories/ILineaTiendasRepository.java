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

    @Query(value = "SELECT Nombre_linea_tiendas as nombre, created_at_linea_tiendas as Creado_en_2025\n" +
            " FROM linea_tiendas\n" +
            " WHERE created_at_linea_tiendas BETWEEN '2025-01-01' AND '2025-12-31'", nativeQuery = true)
    public List<String[]> TiendasCreadasEn2025();
}
