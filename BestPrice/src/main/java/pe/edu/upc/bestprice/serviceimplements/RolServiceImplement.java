package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Rol;
import pe.edu.upc.bestprice.repositories.IRolRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService{

    @Autowired
    private IRolRepository repository;

    @Override
    public List<Rol> listarRoles(){
        return repository.findAll();
    }

    @Override
    public void insertarRol(Rol rol){
        repository.save(rol);
    }

    @Override
    public void edit(Rol r) {
        repository.save(r);
    }

    @Override
    public Rol listarId(int idRol) {
        return repository.findById(idRol).orElse(null);
    }

    @Override
    public void delete(int idRol) {
        repository.deleteById(idRol);
    }
}