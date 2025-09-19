package pe.edu.upc.apibestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apibestprice.entities.Usuario;

import java.util.List;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer>{
    @Query(value = "SELECT u.id_usuario, u.nombre FROM usuario u WHERE u.nombre LIKE '%nombre%'", nativeQuery = true)
    public List<Usuario> buscarUsuario(@Param("nombre") String nombre);
}
