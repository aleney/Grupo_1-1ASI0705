package pe.edu.upc.apibestprice.dtos;

import java.time.LocalDateTime;

public class TicketRespuestaDTO {
    public int idTicketRes;

    public String detalle;

    public LocalDateTime createdAt;

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
}
