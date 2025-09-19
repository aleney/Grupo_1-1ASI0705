package pe.edu.pe.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.HistorialPrecio;
import pe.edu.pe.bestprice.repositories.IHistorialPrecioRepository;
import pe.edu.pe.bestprice.serviceinterfaces.IHistorialPrecioService;

import java.time.LocalDate;
import java.util.List;

@Service
public class HistorialPrecioServiceImplement implements IHistorialPrecioService {
    @Autowired
    private IHistorialPrecioRepository repository;

    @Override
    public List<HistorialPrecio> list() {
        return repository.findAll();
    }

    @Override
    public void insert(HistorialPrecio hp) {
        repository.save(hp);
    }

    @Override
    public HistorialPrecio listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(HistorialPrecio hp) {
        repository.save(hp);
    }

    @Override
    public List<HistorialPrecio> buscarPorProducto(int idProducto) {
        return repository.buscarPorProducto(idProducto); // usar el @Query definido
    }

    @Override
    public List<HistorialPrecio> buscarPorFecha(LocalDate fecha) {
        return repository.buscarPorRangoFechas(fecha, fecha);
    }
}
