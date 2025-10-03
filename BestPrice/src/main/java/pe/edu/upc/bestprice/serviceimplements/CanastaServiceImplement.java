package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.repositories.ICanastaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ICanastaService;

import java.util.List;
@Service("CanastaServiceImplement")
public class CanastaServiceImplement implements ICanastaService {

    @Autowired
    private ICanastaRepository repository;

    @Override
    public List<Canasta> list(){return repository.findAll();} //obtener todas las canastas desde el repositorio

    @Override
    public void insert(Canasta c){repository.save(c);} // insertar nnueva canasta

    @Override
    public Canasta listId(int id){return repository.findById(id).orElse(null);} //obtener canasta por id

    @Override
    public void delete(int id){repository.deleteById(id);}

    @Override
    public void edit(Canasta c){repository.save(c);}

    @Override
    public List<Canasta> buscarService(String usuario) {
        return repository.findAll();
    }

}
