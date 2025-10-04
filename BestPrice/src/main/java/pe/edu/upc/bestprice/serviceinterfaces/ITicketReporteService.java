package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TicketReporte;

import java.util.List;

public interface ITicketReporteService {
    public List<TicketReporte> listarTicketReporte();
    public void insertarTicketReporte(TicketReporte ticketReporte);
}
