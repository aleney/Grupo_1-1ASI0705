package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.entities.Usuario;

import java.util.List;

public interface ITicketReporteService {
    public List<TicketReporte> listarTicketReporte();
    public void insertarTicketReporte(TicketReporte ticketReporte);
    public void edit(TicketReporte ticketReporte);
    public TicketReporte listarId(int idTicketReporte);
    public void delete(int idTicketReporte);
}
