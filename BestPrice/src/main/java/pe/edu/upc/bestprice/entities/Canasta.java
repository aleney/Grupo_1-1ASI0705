package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
@Entity
@Table(name = "Canasta")
public class Canasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCanasta;

    @Column(name = "nombreCanasta",length = 50,nullable = false)
    private String nombreCanasta;

    @Column(name = "createdACanasta",nullable = false)
    private Timestamp createdACanasta;

    @Column(name = "updateACanasta",nullable = false)
    private Timestamp updateACanasta;

    @Column(name = "usuarioCanasta",length = 50,nullable = false)
    private String usuarioCanasta;

    public Canasta() {
    }

    public Canasta(int idCanasta, String nombreCanasta, Timestamp createdACanasta, Timestamp updateACanasta, String usuarioCanasta) {
        this.idCanasta = idCanasta;
        this.nombreCanasta = nombreCanasta;
        this.createdACanasta = createdACanasta;
        this.updateACanasta = updateACanasta;
        this.usuarioCanasta = usuarioCanasta;
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
        return createdACanasta;
    }

    public void setCreatedACanasta(Timestamp createdACanasta) {
        this.createdACanasta = createdACanasta;
    }

    public Timestamp getUpdateACanasta() {
        return updateACanasta;
    }

    public void setUpdateACanasta(Timestamp updateACanasta) {
        this.updateACanasta = updateACanasta;
    }

    public String getUsuarioCanasta() {
        return usuarioCanasta;
    }

    public void setUsuarioCanasta(String usuarioCanasta) {
        this.usuarioCanasta = usuarioCanasta;
    }
}


