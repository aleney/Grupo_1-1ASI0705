package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.entities.Usuario;

import java.time.LocalDateTime;

public class TicketRespuestaDTOInsert {

    private int idTicketRes;

    private String detalle;

    private TicketReporte ticketReporte;


    public int getIdTicketRes() {
        return idTicketRes;
    }

    public void setIdTicketRes(int idTicketRes) {
        this.idTicketRes = idTicketRes;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public TicketReporte getTicketReporte() {
        return ticketReporte;
    }

    public void setTicketReporte(TicketReporte ticketReporte) {
        this.ticketReporte = ticketReporte;
    }
}
