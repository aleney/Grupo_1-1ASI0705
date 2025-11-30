package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.repositories.ITicketReporteRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketReporteService;

import java.util.List;

@Service
public class TicketReporteServiceImplement implements ITicketReporteService {
    @Autowired
    private ITicketReporteRepository repository;

    @Override
    public List<TicketReporte> listarTicketReporte() {
        return repository.findAll();
    }

    @Override
    public void insertarTicketReporte(TicketReporte ticketReporte) {
        repository.save(ticketReporte);
    }

    @Override
    public void edit(TicketReporte ticketReporte) {
        repository.save(ticketReporte);
    }

    @Override
    public TicketReporte listarId(int idTicketReporte) {
        return repository.findById(idTicketReporte).orElse(null);
    }
}
