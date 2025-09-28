package pe.edu.upc.BestPrice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.BestPrice.entities.CategoriaProducto;
import pe.edu.upc.BestPrice.repositories.ICategoriaProductoRepository;
import pe.edu.upc.BestPrice.servicesinterfaces.ICategoriaProductoService;

import java.util.List;

@Service
public class CategoriaProductoServiceImplement implements ICategoriaProductoService {

    @Autowired
    private ICategoriaProductoRepository Cpr;


    @Override
    public List<CategoriaProducto> listarCategoriaProducto() {
        return Cpr.findAll();
    }

    @Override
    public void insertarCateProduct(CategoriaProducto catePro) {
        Cpr.save(catePro);
    }

    @Override
    public CategoriaProducto listId(int id) {
        return Cpr.findById(id).orElse(null);
    }

    @Override
    public void update(CategoriaProducto catePro) {
        Cpr.save(catePro);
    }

    @Override
    public void delete(int id) {
        Cpr.deleteById(id);
    }
}
