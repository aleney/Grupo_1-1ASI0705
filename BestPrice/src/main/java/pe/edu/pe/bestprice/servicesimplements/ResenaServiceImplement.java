package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.Resena;
import pe.edu.pe.bestprice.repositories.IResenaRepository;
import pe.edu.pe.bestprice.servicesinterfaces.IResenaService;

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
    public List<String[]> ListarCalificacionPorResena() {
        return repository.ListarCalificacionPorResena();
    }
}
