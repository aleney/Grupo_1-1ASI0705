package pe.edu.upc.apibestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.apibestprice.entities.TicketRespuesta;
import pe.edu.upc.apibestprice.repositories.ITicketRespuestaRepository;
import pe.edu.upc.apibestprice.serviceinterfaces.ITicketRespuestaService;

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
