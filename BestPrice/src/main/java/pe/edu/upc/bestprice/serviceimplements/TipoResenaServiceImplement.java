package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;
import pe.edu.upc.bestprice.repositories.ITipoResenaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TipoResenaServiceImplement implements ITipoResenaService {

    @Autowired
    private ITipoResenaRepository tipoResenaRepository;

    @Override
    public List<TipoResena> getAllTipoResena() {
        return tipoResenaRepository.findAll();
    }

    @Override
    public TipoResena getTipoResenaById(int id) {
        Optional<TipoResena> tipoResena = tipoResenaRepository.findById(id);
        return tipoResena.orElse(null); // Devuelve null si no se encuentra
    }

    @Override
    public TipoResena createTipoResena(TipoResena tipoResena) {
        return tipoResenaRepository.save(tipoResena);
    }

    @Override
    public void updateTipoResena(TipoResena tipoResena) {
        tipoResenaRepository.save(tipoResena);
    }

    @Override
    public void deleteTipoResena(int id) {
        tipoResenaRepository.deleteById(id);
    }
}
