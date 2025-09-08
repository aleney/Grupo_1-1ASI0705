package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.LineaTiendas;
import pe.edu.pe.bestprice.repositories.ILineaTiendasRepository;
import pe.edu.pe.bestprice.servicesinterfaces.ILineaTiendasService;

import java.util.List;
@Service
public class LineaTiendasServiceImplement implements ILineaTiendasService {

    @Autowired
    private ILineaTiendasRepository repository;

    @Override
    public List<LineaTiendas>list(){
        return repository.findAll();
    }

    @Override
    public void insert(LineaTiendas lt) {
        repository.save(lt);
    }
}
