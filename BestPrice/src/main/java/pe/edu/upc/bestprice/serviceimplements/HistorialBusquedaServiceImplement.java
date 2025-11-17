package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;
import pe.edu.upc.bestprice.repositories.IHistorialBusquedaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class HistorialBusquedaServiceImplement implements IHistorialBusquedaService {

    @Autowired
    private IHistorialBusquedaRepository historialBusquedaRepository;

    @Override
    public List<HistorialBusqueda> getAllHistorialBusqueda() {
        return historialBusquedaRepository.findAll();
    }

    @Override
    public HistorialBusqueda getHistorialBusquedaById(int id) {
        Optional<HistorialBusqueda> historialBusqueda = historialBusquedaRepository.findById(id);
        return historialBusqueda.orElse(null); // Devuelve null si no se encuentra
    }

    @Override
    public HistorialBusqueda createHistorialBusqueda(HistorialBusqueda historialBusqueda) {
        return historialBusquedaRepository.save(historialBusqueda);
    }

    @Override
    public void updateHistorialBusqueda(HistorialBusqueda historialBusqueda) {
        historialBusquedaRepository.save(historialBusqueda);
    }

    @Override
    public void deleteHistorialBusqueda(int id) {
        historialBusquedaRepository.deleteById(id);
    }
}
