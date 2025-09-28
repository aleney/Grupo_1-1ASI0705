package pe.edu.upc.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.Tiendas;
import pe.edu.upc.bestprice.repositories.ITiendasRepository;
import pe.edu.upc.bestprice.servicesinterfaces.ITiendasService;

import java.util.List;

@Service
public class TiendasServiceImplement implements ITiendasService {

    @Autowired
    private ITiendasRepository Tr;

    @Override
    public List<Tiendas> listarTiendas() {
        return Tr.findAll();
    }

    @Override
    public void insert(Tiendas tiendas) {
        Tr.save(tiendas);
    }

    @Override
    public Tiendas listarIdTiendas(int id) {
        return Tr.findById(id).orElse(null);
    }
}
