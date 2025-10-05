package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Resena;
import pe.edu.upc.bestprice.repositories.IResenaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IResenaService;

import java.util.List;

@Service
public class ResenaServiceImplement implements IResenaService {

    @Autowired
    private IResenaRepository repository;

    @Override
    public List<Resena> list() {
        return repository.findAll();
    }

    @Override
    public void insert(Resena resena) {
        repository.save(resena);
    }

    @Override
    public void update(Resena resena) {
        repository.save(resena);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public Resena ListId(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<String[]> ListarCalificacionPorTipoResena() {
        return repository.ListarCalificacionPorTipoResena();
    }

    @Override
    public List<String[]> ListarTiendaporCalificacion() {
        return repository.ListarTiendaporCalificacion();
    }
}
