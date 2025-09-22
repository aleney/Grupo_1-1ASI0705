package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.Producto;
import pe.edu.pe.bestprice.repositories.IProductoRepository;
import pe.edu.pe.bestprice.servicesinterfaces.IProductoService;

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
}
