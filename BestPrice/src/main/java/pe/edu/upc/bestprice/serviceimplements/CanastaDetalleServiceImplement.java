package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.CanastaDetalle;
import pe.edu.upc.bestprice.repositories.ICanastaDetalleRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ICanastaDetalleService;

import java.util.List;

@Service

public abstract class CanastaDetalleServiceImplement implements ICanastaDetalleService {
    @Autowired
    private ICanastaDetalleRepository repository;


    @Override
    public void insert(CanastaDetalle cd) {
        repository.save(cd);
    }

    @Override
    public List<CanastaDetalle> list(){return repository.findAll();}

    @Override
    public CanastaDetalle listId(String id){return repository.findById(id).orElse(null);}

    @Override
    public void edit(CanastaDetalle cd) {
        repository.save(cd);
    }

}
