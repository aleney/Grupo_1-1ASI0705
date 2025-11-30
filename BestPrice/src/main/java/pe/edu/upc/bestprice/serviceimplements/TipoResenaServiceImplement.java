package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;
import pe.edu.upc.bestprice.repositories.ITipoResenaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoResenaServiceImplement implements ITipoResenaService {

    @Autowired
    private ITipoResenaRepository repository;


    @Override
    public List<TipoResena> getAllTipoResena() {
        return repository.findAll();
    }

    @Override
    public void createTipoResena(TipoResena tr) {
        repository.save(tr);
    }

    @Override
    public TipoResena getTipoResenaById(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void updateTipoResena(TipoResena tr) {
        repository.save(tr);
    }

    @Override
    public void deleteTipoResena(int id) {
        repository.deleteById(id);
    }

    @Override
    public List<TipoResena> findByTipoResena(String nombre) {
        return repository.findByTipoResena(nombre);
    }

    @Override
    public List<TipoResena> findAllOrderedByName() {
        return repository.findAllOrderedByName();
    }
}
