package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.CanastaDetalle;
import pe.edu.upc.bestprice.repositories.ICanastaDetalleRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ICanastaDetalleService;

import java.util.List;

@Service
public class CanastaDetalleServiceImplement implements ICanastaDetalleService {

    @Autowired
    private ICanastaDetalleRepository repository;

    @Override
    public List<CanastaDetalle> buscarService(String nombre) {
        return repository.findAll();  // Retorna todos los detalles de la canasta
    }

    @Override
    public void insert(CanastaDetalle cd) {
        repository.save(cd);  // Inserta o actualiza el detalle de la canasta
    }

    @Override
    public List<CanastaDetalle> list() {
        return repository.findAll();  // Retorna todos los detalles de la canasta
    }

    @Override
    public CanastaDetalle listId(String id) {
        return repository.findById(id).orElse(null);  // Obtiene un detalle de canasta por ID
    }

    @Override
    public void edit(CanastaDetalle cd) {
        repository.save(cd);  // Guarda el detalle de la canasta (actualiza si ya existe)
    }
}
