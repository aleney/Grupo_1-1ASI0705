package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.repositories.IHistorialBusquedaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;

import java.util.List;

@Service
public class HistorialBusquedaServiceImplement implements IHistorialBusquedaService {

    @Autowired
    private IHistorialBusquedaRepository repository;

    @Override
    public List<HistorialBusqueda> list() {
        return repository.findAll();
    }

    @Override
    public void insert(HistorialBusqueda d) {
        repository.save(d);
    }

    @Override
    public HistorialBusqueda listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
