package pe.edu.pe.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.UbicacionTienda;
import pe.edu.pe.bestprice.repositories.IUbicacionTiendaRepository;
import pe.edu.pe.bestprice.serviceinterfaces.IUbicacionTiendaService;

import java.util.List;

@Service
public class UbicacionTiendaServiceImplement implements IUbicacionTiendaService {
    @Autowired
    private IUbicacionTiendaRepository repository;

    @Override
    public List<UbicacionTienda> list() {
        return repository.findAll();
    }

    @Override
    public void insert(UbicacionTienda u) {
        repository.save(u);
    }

    @Override
    public UbicacionTienda listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(UbicacionTienda u) {
        repository.save(u);
    }
}
