package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Rol")

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "tipoUsuario",length = 20, nullable = false)
    private String tipoUsuario;

    @Column(name = "createdAt",nullable = false)
    private LocalDate createdAt;

    @Column(name = "updatedAt",nullable = false)
    private LocalDateTime updatedAt;

    public Rol(int idRol, String tipoUsuario, LocalDate createdAt, LocalDateTime updatedAt) {
        this.idRol = idRol;
        this.tipoUsuario = tipoUsuario;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Rol() {

    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
