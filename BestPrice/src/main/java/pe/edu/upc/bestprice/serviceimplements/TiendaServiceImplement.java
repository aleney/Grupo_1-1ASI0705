package pe.edu.upc.bestprice.serviceimplements;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Tienda;
import pe.edu.upc.bestprice.repositories.ITiendaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITiendaService;

import java.util.List;

@Service
public class TiendaServiceImplement implements ITiendaService {

    @Autowired
    private ITiendaRepository Tr;

    @Override
    public List<Tienda> listarTienda() {
        return Tr.findAll();
    }

    @Override
    public void insert(Tienda Tienda) {
        Tr.save(Tienda);
    }

    @Override
    public Tienda listarIdTienda(int id) {
        return Tr.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        Tr.deleteById(id);
    }

    @Override
    public void update(Tienda t) {
        Tr.save(t);
    }
}
