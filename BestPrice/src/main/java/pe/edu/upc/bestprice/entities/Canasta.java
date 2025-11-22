package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Canasta")
public class Canasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanasta;

    @Column(name = "nombreCanasta", length = 50, nullable = false)
    private String nombreCanasta;

    @CreationTimestamp
    @Column(name = "createdAtCanasta", nullable = false, updatable = false)
    private LocalDateTime createdAtCanasta;

    @UpdateTimestamp
    @Column(name = "updatedAtCanasta", nullable = false)
    private LocalDateTime updatedAtCanasta;

    @Column(name = "usuarioCanasta", length = 50, nullable = false)
    private String usuarioCanasta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Canasta(Usuario usuario) {
        this.usuario = usuario;
    }

    public Canasta() {
    }

    public int getIdCanasta() {
        return idCanasta;
    }

    public void setIdCanasta(int idCanasta) {
        this.idCanasta = idCanasta;
    }

    public String getNombreCanasta() {
        return nombreCanasta;
    }

    public void setNombreCanasta(String nombreCanasta) {
        this.nombreCanasta = nombreCanasta;
    }

    public LocalDateTime getCreatedAtCanasta() {
        return createdAtCanasta;
    }

    public void setCreatedAtCanasta(LocalDateTime createdAtCanasta) {
        this.createdAtCanasta = createdAtCanasta;
    }

    public LocalDateTime getUpdatedAtCanasta() {
        return updatedAtCanasta;
    }

    public void setUpdatedAtCanasta(LocalDateTime updatedAtCanasta) {
        this.updatedAtCanasta = updatedAtCanasta;
    }
}