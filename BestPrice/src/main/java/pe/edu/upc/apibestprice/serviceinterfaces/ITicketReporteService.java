package pe.edu.upc.apibestprice.serviceinterfaces;

import pe.edu.upc.apibestprice.entities.TicketReporte;

import java.util.List;

public interface ITicketReporteService {
    public List<TicketReporte> listarTicketReporte();
    public void insertarTicketReporte(TicketReporte ticketReporte);
}
