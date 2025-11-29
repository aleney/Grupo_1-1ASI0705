package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Usuario;

import java.time.LocalDateTime;

public class TicketReporteDTOInsert {

    private int idTicketRep;

    private String detalle;

    private Boolean ticketStatus;

    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
