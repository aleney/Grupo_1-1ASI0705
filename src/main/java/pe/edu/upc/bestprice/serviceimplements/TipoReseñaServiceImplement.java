package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TipoReseña;
import pe.edu.upc.bestprice.repositories.ITipoReseñaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoReseñaService;

import java.util.List;

@Service
public class TipoReseñaServiceImplement implements ITipoReseñaService {

    @Autowired
    private ITipoReseñaRepository repository;

    @Override
    public List<TipoReseña> list(){
        return repository.findAll();
    }

    @Override
    public void insert(TipoReseña tipo){
        repository.save(tipo);
    }

}
