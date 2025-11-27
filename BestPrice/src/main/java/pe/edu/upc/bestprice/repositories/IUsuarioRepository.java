package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.bestprice.entities.Usuario;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findOneByNombre(String nombre);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (idRol, tipoUsuario) VALUES (:id_rol, :tipo_usuario)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

    //BUSCAR POR NOMBRE
    @Query(value = "Select *from Usuario WHERE nombre like (CONCAT('%', :nombre, '%'))", nativeQuery = true)
    List<Usuario> buscarUsuario(@Param("nombre") String nombre);

    // Filtrar por estado (true = activo, false = inactivo)
    @Query(value = "SELECT id_usuario, nombre, created_at, estado FROM usuario WHERE estado = true", nativeQuery = true)
    List<String[]> filtrarUsuariosPorEstado();


}
