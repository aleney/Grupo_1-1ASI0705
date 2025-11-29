package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.TicketReporte;

import java.time.LocalDateTime;

public class TicketRespuestaDTOList {

    private int idTicketRes;

    private String detalle;

    private LocalDateTime createdAtTicketRespuesta;

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

    public LocalDateTime getCreatedAtTicketRespuesta() {
        return createdAtTicketRespuesta;
    }

    public void setCreatedAtTicketRespuesta(LocalDateTime createdAtTicketRespuesta) {
        this.createdAtTicketRespuesta = createdAtTicketRespuesta;
    }

    public TicketReporte getTicketReporte() {
        return ticketReporte;
    }

    public void setTicketReporte(TicketReporte ticketReporte) {
        this.ticketReporte = ticketReporte;
    }
}
