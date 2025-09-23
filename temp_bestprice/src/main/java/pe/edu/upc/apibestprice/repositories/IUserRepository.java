package pe.edu.upc.apibestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.apibestprice.entities.Usuario;


@Repository
public interface IUserRepository extends JpaRepository<Usuario, Long> {
    public Usuario findOneByNombre(String nombre);

    //BUSCAR POR NOMBRE
    @Query("select count(u.nombre) from Usuario u where u.nombre =:username")
    public int buscarNombre(@Param("nombre") String nombre);


    //INSERTAR ROLES
    @Transactional
    @Modifying
    @Query(value = "insert into roles (idRol, tipoUsuario) VALUES (:id_rol, :tipo_usuario)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);

}