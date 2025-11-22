package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
@Entity
@Table(name = "Canasta")
public class Canasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanasta;

    @Column(name = "nombreCanasta",length = 50,nullable = false)
    private String nombreCanasta;

    @CreationTimestamp
    @Column(name = "createdAtCanasta",nullable = false,updatable = false)
    private Timestamp createdAtCanasta;

    @UpdateTimestamp
    @Column(name = "updatedAtCanasta",nullable = false)
    private Timestamp updatedAtCanasta;

    @Column(name = "usuarioCanasta",length = 50,nullable = false)
    private String usuarioCanasta;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Canasta(Usuario usuario){
        this.usuario = usuario;
    }

    public Canasta() {
    }

    public Canasta(int idCanasta, String nombreCanasta, Timestamp createdAtCanasta, Timestamp updatedAtCanasta, String usuarioCanasta) {
        this.idCanasta = idCanasta;
        this.nombreCanasta = nombreCanasta;
        this.createdAtCanasta = createdAtCanasta;
        this.updatedAtCanasta = updatedAtCanasta;
        this.usuarioCanasta = usuarioCanasta;
    }

    public Timestamp getCreatedAtCanasta() {
        return createdAtCanasta;
    }

    public void setCreatedAtCanasta(Timestamp createdAtCanasta) {
        this.createdAtCanasta = createdAtCanasta;
    }

    public Timestamp getUpdatedAtCanasta() {
        return updatedAtCanasta;
    }

    public void setUpdatedAtCanasta(Timestamp updatedAtCanasta) {
        this.updatedAtCanasta = updatedAtCanasta;
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

    public Timestamp getCreatedACanasta() {
        return createdAtCanasta;
    }

    public void setCreatedACanasta(Timestamp createdAtCanasta) {
        this.createdAtCanasta = createdAtCanasta;
    }

    public Timestamp getUpdateACanasta() {
        return updatedAtCanasta;
    }

    public void setUpdateACanasta(Timestamp updatedAtCanasta) {
        this.updatedAtCanasta = updatedAtCanasta;
    }

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}


