package pe.edu.upc.apibestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "TicketReporte")

public class TicketReporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int idTicketRep;

    @Column(name = "detalle",length = 99, nullable = false)
    public String detalle;

    @Column(name = "createdAt", nullable = false)
    public LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public TicketReporte(int idTicketRep, String detalle, LocalDateTime createdAt, Usuario usuario) {
        this.idTicketRep = idTicketRep;
        this.detalle = detalle;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
