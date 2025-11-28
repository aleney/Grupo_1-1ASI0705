package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Usuario;
import pe.edu.upc.bestprice.repositories.IUsuarioRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IUsuarioService;

import java.util.List;
@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listarUsuarios(){
     return repository.findAll();
    }

    @Override
    public void insertarUsuario(Usuario usuario){
        if (usuario.getPassword() == null || usuario.getPassword().isBlank()) {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

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
    public void edit(Usuario usuario){
        Usuario actual = repository.findById(usuario.getIdUsuario()).orElse(null);
        if (actual != null) {

            if (!usuario.getPassword().equals(actual.getPassword())) {
                usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
            }
        }
        repository.save(usuario);
    }

    @Override
    public List<String[]> buscarUsuario(String nombre){ return repository.buscarUsuario(nombre);
    }

    @Override
    public List<String[]> listar(){ return repository.listar();};

    @Override
    public List<String[]> listarUsuariosInactivos(String estado) {
        return repository.listarUsuariosInactivos(estado);
    }

}
