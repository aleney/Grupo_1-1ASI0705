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

    //BUSCAR POR NOMBRE
    @Query("select count(u.nombre) from Usuario u where u.nombre =:username")
    public int buscarNombre(@Param("nombre") String nombre);

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

    @Query(value = "select *from usuario \n" +
            "where estado = %estado%", nativeQuery = true)
    public List<String[]> listarUsuariosInactivos(String estado);

    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (idRol, tipoUsuario) VALUES (:id_rol, :tipo_usuario)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}