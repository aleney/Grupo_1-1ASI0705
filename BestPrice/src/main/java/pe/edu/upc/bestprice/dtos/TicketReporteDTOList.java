package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Usuario;

import java.time.LocalDateTime;

public class TicketReporteDTOList {
    private int idTicketRep;

    private String detalle;

    private Boolean ticketStatus;

    private LocalDateTime createdAtTicketReporte;

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getCreatedAtTicketReporte() {
        return createdAtTicketReporte;
    }

    public void setCreatedAtTicketReporte(LocalDateTime createdAtTicketReporte) {
        this.createdAtTicketReporte = createdAtTicketReporte;
    }

    public Boolean getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(Boolean ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getIdTicketRep() {
        return idTicketRep;
    }

    public void setIdTicketRep(int idTicketRep) {
        this.idTicketRep = idTicketRep;
    }
}
