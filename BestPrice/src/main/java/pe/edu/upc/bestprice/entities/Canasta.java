package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
    @Column(name = "createdAtCanasta", nullable = true, updatable = false)
    private LocalDateTime createdAtCanasta;

    @UpdateTimestamp
    @Column(name = "updatedAtCanasta", nullable = true)
    private LocalDateTime updatedAtCanasta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario idUsuario;

    public Canasta(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Canasta() {
    }

    public Canasta(int idCanasta, String nombreCanasta, Usuario idUsuario) {
        this.idCanasta = idCanasta;
        this.nombreCanasta = nombreCanasta;
        this.idUsuario = idUsuario;
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

    public Usuario getUsuario() {
        return idUsuario;
    }

    public void setUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}