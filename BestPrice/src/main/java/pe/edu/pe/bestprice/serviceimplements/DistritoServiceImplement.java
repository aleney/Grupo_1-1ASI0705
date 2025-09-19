package pe.edu.pe.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.Distrito;
import pe.edu.pe.bestprice.repositories.IDistritoRepository;
import pe.edu.pe.bestprice.serviceinterfaces.IDistritoService;

import java.util.List;

@Service
public class DistritoServiceImplement implements IDistritoService {
    @Autowired
    private IDistritoRepository repository;

    @Override
    public List<Distrito> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Distrito d) {
        repository.save(d);
    }

    @Override
    public Distrito listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(Distrito d) {
        repository.save(d);
    }
}
