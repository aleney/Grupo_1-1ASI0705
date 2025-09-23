package pe.edu.upc.apibestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apibestprice.entities.TicketReporte;
import pe.edu.upc.apibestprice.entities.TicketRespuesta;
import pe.edu.upc.apibestprice.repositories.ITicketReporteRepository;
import pe.edu.upc.apibestprice.serviceinterfaces.ITicketReporteService;

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
}
