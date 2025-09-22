package pe.edu.upc.apibestprice.serviceinterfaces;

import pe.edu.upc.apibestprice.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> listarUsuarios();
    public void insertarUsuario(Usuario usuario);
    public Usuario listarId(int idUsuario);
    public void delete(int idUsuario);
    public void edit(Usuario p);
    public List<String[]> buscarUsuario(String nombre);
    public List<String[]> listar();
}
