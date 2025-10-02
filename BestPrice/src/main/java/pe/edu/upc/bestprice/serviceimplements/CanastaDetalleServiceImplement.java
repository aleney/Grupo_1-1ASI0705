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

    // Buscar detalles de canasta por nombre (ajustar según el campo real)
    @Override
    public List<CanastaDetalle> buscarService(String nombre) {
        // Ajustar según el campo real de búsqueda
        return repository.findAll(nombre);  // Buscar por nombre
    }

<<<<<<< Updated upstream
    @Override
    public void insert(CanastaDetalle cd) {
        repository.save(cd);
=======
    // Insertar un detalle de canasta
    @Override
    public void insert(CanastaDetalle cd) {
        repository.save(cd);  // Guardar el detalle de la canasta
>>>>>>> Stashed changes
    }

    // Listar todos los detalles de canasta
    @Override
    public List<CanastaDetalle> list() {
        return repository.findAll();  // Obtener todos los detalles de la canasta
    }

    // Obtener un detalle de canasta por ID
    @Override
    public CanastaDetalle listId(String id) {
        return repository.findById(id).orElse(null);  // Obtener por ID, devuelve null si no existe
    }

<<<<<<< Updated upstream
    @Override
    public void edit(CanastaDetalle cd) {
        repository.save(cd);
    }

=======
    // Editar un detalle de canasta
    @Override
    public void edit(CanastaDetalle cd) {
        repository.save(cd);  // Actualizar el detalle de la canasta
    }
>>>>>>> Stashed changes
}

