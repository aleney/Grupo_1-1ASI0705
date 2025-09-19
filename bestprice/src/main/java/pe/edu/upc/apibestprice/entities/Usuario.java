package pe.edu.upc.apibestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name = "Usuario")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nombre",length = 50,nullable = false)
    private String nombre;

    @Column(name = "email",length = 99,nullable = false)
    private String email;

    @Column(name = "password",length = 50,nullable = false)
    private String pasword;

    @Column(name = "numeroTelefono",length = 9,nullable = false)
    private int numeroTelefono;

    @Column(name = "estado",length = 9,nullable = false)
    private Boolean estado;

    @Column(name = "createdAt",length = 9,nullable = false)
    private LocalDate createdAt;

    @Column(name = "updatedAt",length = 9,nullable = false)
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private Rol rol;

    public Usuario(int idUsuario, String nombre, String email, String pasword, int numeroTelefono, Boolean estado, LocalDate createdAt, LocalDate updatedAt, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.pasword = pasword;
        this.numeroTelefono = numeroTelefono;
        this.estado = estado;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.rol = rol;
    }

    public Usuario() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
