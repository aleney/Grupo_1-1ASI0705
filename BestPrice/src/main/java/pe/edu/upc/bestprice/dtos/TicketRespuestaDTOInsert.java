package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.TicketReporte;

import java.time.LocalDateTime;

public class TicketRespuestaDTOInsert {
    public int idTicketRes;

    public String detalle;

    public LocalDateTime createdAt;

    public int ticketReporte;

    public int usuario;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public int getTicketReporte() {
        return ticketReporte;
    }

    public void setTicketReporte(int ticketReporte) {
        this.ticketReporte = ticketReporte;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
}
