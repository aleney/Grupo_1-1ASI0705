package pe.edu.upc.apibestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apibestprice.entities.Rol;
import pe.edu.upc.apibestprice.repositories.IRolRepository;
import pe.edu.upc.apibestprice.serviceinterfaces.IRolService;

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
}
