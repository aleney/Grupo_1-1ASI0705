package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.OfertasProducto;
import pe.edu.upc.bestprice.repositories.IOfertasProductoRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IOfertasProductoService;

import java.time.LocalDate;
import java.util.List;

@Service
public class OfertasProductoServiceImplement implements IOfertasProductoService {
    @Autowired
    private IOfertasProductoRepository repository;

    @Override
    public List<OfertasProducto> list() {
        return repository.findAll();
    }

    @Override
    public void insert(OfertasProducto op) {
        repository.save(op);
    }

    @Override
    public OfertasProducto listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void edit(OfertasProducto op) {
        repository.save(op);
    }

    @Override
    public List<OfertasProducto> buscarPorProductoYFecha(int idProducto, LocalDate fecha) {
        return repository.buscarPorProductoYFecha(idProducto, fecha);
    }

    @Override
    public List<OfertasProducto> buscarPorProductoYRangoFechas(int idProducto, LocalDate fechaInicio, LocalDate fechaFin) {
        return repository.buscarPorProductoYRangoFechas(idProducto, fechaInicio, fechaFin);
    }
}
