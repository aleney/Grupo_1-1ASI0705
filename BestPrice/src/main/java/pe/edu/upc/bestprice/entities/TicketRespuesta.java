package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TicketRespuesta")

public class TicketRespuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTicketRes;

    @Column(name = "detalle",length = 99, nullable = false)
    public String detalle;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = true, updatable = false)
    public LocalDateTime createdAtTicketRespuesta;

    @OneToOne
    @JoinColumn(name="idTicketRep")
    private TicketReporte ticketReporte;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public TicketRespuesta(int idTicketRes, String detalle, TicketReporte ticketReporte, Usuario usuario) {
        this.idTicketRes = idTicketRes;
        this.detalle = detalle;
        this.ticketReporte = ticketReporte;
        this.usuario = usuario;
    }

    public TicketRespuesta() {

    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}
