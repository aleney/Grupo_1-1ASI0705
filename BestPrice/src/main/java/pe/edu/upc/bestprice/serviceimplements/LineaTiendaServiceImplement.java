package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.LineaTienda;
import pe.edu.upc.bestprice.repositories.ILineaTiendaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ILineaTiendaService;

import java.util.List;
@Service
public class LineaTiendaServiceImplement implements ILineaTiendaService {

    @Autowired
    private ILineaTiendaRepository repository;

    @Override
    public List<LineaTienda>list(){
        return repository.findAll();
    }

    @Override
    public void insert(LineaTienda lt) {
        repository.save(lt);
    }

    @Override
    public LineaTienda ListId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(LineaTienda lt) {
        repository.save(lt);
    }

    @Override
    public List<LineaTienda> buscarService(String nombre) {
        return repository.buscar(nombre);
    }

    @Override
    public List<String[]> TiendaCreadasEn2025() {
        return repository.TiendaCreadasEn2025();
    }


}
