package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.CategoriaProducto;
import pe.edu.upc.bestprice.repositories.ICategoriaProductoRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ICategoriaProductoService;

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
    public void delete(int id) {
        Cpr.deleteById(id);
    }

    @Override
    public void update(CategoriaProducto cp) {
        Cpr.save(cp);
    }
}
