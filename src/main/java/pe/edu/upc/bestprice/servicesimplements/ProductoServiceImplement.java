package pe.edu.upc.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Producto;
import pe.edu.upc.bestprice.repositories.IProductoRepository;
import pe.edu.upc.bestprice.servicesinterfaces.IProductoService;

import java.util.List;

@Service
public class ProductoServiceImplement implements IProductoService {

    @Autowired
    private IProductoRepository Pr;


    @Override
    public List<Producto> List() {
        return Pr.findAll();
    }

    @Override
    public void insert(Producto p) {
        Pr.save(p);
    }

    @Override
    public Producto listId(int id) {
        return Pr.findById(id).orElse(null);
    }

    @Override
    public void update(Producto p) {
        Pr.save(p);
    }

    @Override
    public void delete(int id) {
        Pr.deleteById(id);
    }
}
