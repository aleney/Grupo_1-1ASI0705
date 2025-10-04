package pe.edu.upc.bestprice.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Producto;
import pe.edu.upc.bestprice.repositories.IProductoRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepository repository;


    @Override
    public List<Producto> List() {
        return repository.findAll();
    }

    @Override
    public void insert(Producto p) {
        repository.save(p);
    }

    @Override
    public Producto listId(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Producto p) {
        repository.save(p);
    }
}
