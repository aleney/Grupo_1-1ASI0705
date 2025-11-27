package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();
    public void insertarUsuario(Usuario usuario);
    public Usuario listarId(int idUsuario);
    public void delete(int idUsuario);
    public void edit(Usuario p);
    List<Usuario> buscarUsuario(String nombre);
    public List<String[]> filtrarUsuariosPorEstado();
}
