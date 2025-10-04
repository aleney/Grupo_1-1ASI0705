package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
    @Query(value = "SELECT u.nombre, u.email, u.estado, r.tipo_usuario\n" +
            "FROM usuario u\n" +
            "INNER JOIN rol r \n" +
            "ON u.id_rol = r.id_rol;", nativeQuery = true)
    public List<String[]> buscarUsuario(@Param("nombre") String nombre);

    @Query(value="SELECT u.nombre, u.email, u.estado, r.tipo_usuario\n" +
            "FROM usuario u\n" +
            "INNER JOIN rol r \n" +
            "ON u.id_rol = r.id_rol;", nativeQuery = true)
    public List<String[]> listar();
}
