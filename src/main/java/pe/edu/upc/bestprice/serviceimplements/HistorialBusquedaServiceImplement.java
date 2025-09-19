package pe.edu.upc.bestprice.serviceimplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.repositories.IHistorialBusquedaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;

import java.util.List;

@Service
public abstract class HistorialBusquedaServiceImplement implements IHistorialBusquedaService {

    @Autowired
    private IHistorialBusquedaRepository repository;

    @Override
    public List<HistorialBusqueda>list(){
        return repository.findAll();

    }

    @Override
    public void insert(HistorialBusqueda historial){
        repository.save(historial);
    }

    @Override
    public HistorialBusqueda listId(int id){
        return repository.findById(String.valueOf(id)).orElse(null);
    }

    @Override
    public void delete(int id){repository.deleteById(id);}

    @Override
    public void edit(HistorialBusqueda historial){
        repository.save(historial);
    }

    @Override
    public List<HistorialBusqueda> buscarService(Integer id){
        return repository.buscar(id);
    }

}