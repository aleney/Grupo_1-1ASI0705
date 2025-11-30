package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TicketRespuesta;

import java.util.List;

public interface ITicketRespuestaService {
    public List<TicketRespuesta> listarTicketRespuesta();
    public void insertarTicketRespuesta(TicketRespuesta ticketRespuesta);
}
