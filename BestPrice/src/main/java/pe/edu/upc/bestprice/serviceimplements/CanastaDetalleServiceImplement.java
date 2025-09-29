package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.CanastaDetalle;
import pe.edu.upc.bestprice.repositories.ICanastaDetalleRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ICanastaService;

import java.util.List;

@Service

public abstract class CanastaDetalleServiceImplement implements ICanastaService {
    @Autowired
    private ICanastaDetalleRepository repository;


    /*@Override
    public void insert(CanastaDetalle cd) {
        repository.save(cd);
    }*/

    @Override
    public CanastaDetalle listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

   /* @Override
    public void edit(CanastaDetalle cd) {
        repository.save(cd);
    }*/

    /*@Override
    public List<CanastaDetalle> buscarService(String nombre) {
        return repository.buscar(nombre);
    }*/

    public abstract CanastaDetalle listId(String id);
}
