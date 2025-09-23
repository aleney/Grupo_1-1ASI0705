package pe.edu.upc.apibestprice.serviceinterfaces;

import pe.edu.upc.apibestprice.entities.TicketRespuesta;

import java.util.List;

public interface ITicketRespuestaService {
    public List<TicketRespuesta> listarTicketRespuesta();
    public void insertarTicketRespuesta(TicketRespuesta ticketRespuesta);
}
