package pe.edu.upc.apibestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apibestprice.entities.Usuario;
import pe.edu.upc.apibestprice.repositories.IUsuarioRepository;
import pe.edu.upc.apibestprice.serviceinterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;

    @Override
    public List<Usuario> listarUsuarios(){
     return repository.findAll();
    }

    @Override
    public void insertarUsuario(Usuario usuario){
        repository.save(usuario);
    }

    @Override
    public Usuario listarId(int idUsuario){
        return repository.findById(idUsuario).orElse(null);
    }

    @Override
    public void delete(int idUsuario){
        repository.deleteById(idUsuario);
    }

    @Override
    public void edit(Usuario p){
        repository.save(p);
    }

    @Override
    public List<Usuario> buscarUsuario(String nombre){ return repository.buscarUsuario(nombre);
    }


}
