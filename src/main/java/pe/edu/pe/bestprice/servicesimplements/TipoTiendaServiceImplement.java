package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.TipoTienda;
import pe.edu.pe.bestprice.repositories.ITipoTiendaRepository;
import pe.edu.pe.bestprice.servicesinterfaces.ITipoTiendaService;

import java.util.List;

@Service
public class TipoTiendaServiceImplement implements ITipoTiendaService {

    @Autowired
    private ITipoTiendaRepository Ttr;


    @Override
    public List<TipoTienda> listarTipoTiendas() {
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
    public void update(TipoTienda tipoTienda) {
        Ttr.save(tipoTienda);
    }

    @Override
    public void delete(int id) {
        Ttr.deleteById(id);
    }
}
