package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class TicketReporteDTOList {
    public int idTicketRep;

    public String detalle;

    public Boolean ticketStatus;

    public int getIdTicketRep() {
        return idTicketRep;
    }

    public void setIdTicketRep(int idTicketRep) {
        this.idTicketRep = idTicketRep;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Boolean getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
