package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TipoTienda;
import pe.edu.upc.bestprice.repositories.ITipoTiendaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoTiendaService;

import java.util.List;

@Service
public class TipoTiendaServiceImplement implements ITipoTiendaService {

    @Autowired
    private ITipoTiendaRepository Ttr;


    @Override
    public List<TipoTienda> listarTipoTienda() {
        return Ttr.findAll();
    }

    @Override
    public void insert(TipoTienda tipoTienda) {
        Ttr.save(tipoTienda);
    }

    @Override
    public TipoTienda listarIdTipoTienda(int id) {
        return Ttr.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        Ttr.deleteById(id);
    }

    @Override
    public void update(TipoTienda tt) {
        Ttr.save(tt);
    }
}
