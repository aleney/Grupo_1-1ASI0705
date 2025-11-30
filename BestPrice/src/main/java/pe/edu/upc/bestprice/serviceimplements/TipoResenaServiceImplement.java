package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.LineaTienda;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.repositories.ITipoResenaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;

import java.util.List;

@Service
public class TipoResenaServiceImplement implements ITipoResenaService {

    @Autowired
    private ITipoResenaRepository repository;

    @Override
    public List<TipoResena> listarTipoResena() {
        return repository.findAll();
    }

    @Override
    public TipoResena ListId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void insert(TipoResena t) {
        repository.save(t);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(TipoResena t) {
        repository.save(t);
    }
}
