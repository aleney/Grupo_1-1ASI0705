package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "TicketReporte")

public class TicketReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTicketRep;

    @Column(name = "detalle",length = 99, nullable = false)
    public String detalle;


    @Column(name = "status", nullable = false)
    public Boolean ticketStatus;

    @CreationTimestamp
    @Column(name = "createdAt", nullable = true, updatable = false)
    public LocalDateTime createdAtTicketReporte;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public TicketReporte(int idTicketRep, String detalle, Boolean ticketStatus, Usuario usuario) {
        this.idTicketRep = idTicketRep;
        this.detalle = detalle;
        this.ticketStatus = ticketStatus;
        this.usuario = usuario;
    }

    public TicketReporte() {

    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}



