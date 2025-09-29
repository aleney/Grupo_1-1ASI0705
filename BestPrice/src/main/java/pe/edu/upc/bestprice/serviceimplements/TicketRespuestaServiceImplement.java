package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.TicketRespuesta;
import pe.edu.upc.bestprice.repositories.ITicketRespuestaRepository;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketRespuestaService;

import java.util.List;

@Service
public class TicketRespuestaServiceImplement implements ITicketRespuestaService {

    @Autowired
    private ITicketRespuestaRepository repository;

    @Override
    public List<TicketRespuesta> listarTicketRespuesta() {
        return repository.findAll();
    }

    @Override
    public void insertarTicketRespuesta(TicketRespuesta ticketRespuesta){
        repository.save(ticketRespuesta);
    }
}
