package pe.edu.upc.bestprice.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "AuthGoogle")
public class AuthGoogle  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthGoogle;

    @Column(name = "nombreAuthGoogle",  length = 100, nullable = false)
    private String nombreAuthGoogle;

    @Column(name = "emailAuthGoogle", length = 150, nullable = false)
    private String emailAuthGoogle;

    @Column(name = "contrasenaAuthGoogle", length = 99, nullable = false)
    private String contrasenaAuthGoogle;

    @Column(name = "createdAtAuthGoogle", nullable = false)
    private LocalDate createdAtAuthGoogle;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public AuthGoogle() {
    }

    public AuthGoogle(int idAuthGoogle, String nombreAuthGoogle, String emailAuthGoogle, String contrasenaAuthGoogle, LocalDate createdAtAuthGoogle, Usuario usuario) {
        this.idAuthGoogle = idAuthGoogle;
        this.nombreAuthGoogle = nombreAuthGoogle;
        this.emailAuthGoogle = emailAuthGoogle;
        this.contrasenaAuthGoogle = contrasenaAuthGoogle;
        this.createdAtAuthGoogle = createdAtAuthGoogle;
        this.usuario = usuario;
    }

    public int getIdAuthGoogle() {
        return idAuthGoogle;
    }

    public void setIdAuthGoogle(int idAuthGoogle) {
        this.idAuthGoogle = idAuthGoogle;
    }

    public String getNombreAuthGoogle() {
        return nombreAuthGoogle;
    }

    public void setNombreAuthGoogle(String nombreAuthGoogle) {
        this.nombreAuthGoogle = nombreAuthGoogle;
    }

    public String getEmailAuthGoogle() {
        return emailAuthGoogle;
    }

    public void setEmailAuthGoogle(String emailAuthGoogle) {
        this.emailAuthGoogle = emailAuthGoogle;
    }

    public String getContrasenaAuthGoogle() {
        return contrasenaAuthGoogle;
    }

    public void setContrasenaAuthGoogle(String contrasenaAuthGoogle) {
        this.contrasenaAuthGoogle = contrasenaAuthGoogle;
    }

    public LocalDate getCreatedAtAuthGoogle() {
        return createdAtAuthGoogle;
    }

    public void setCreatedAtAuthGoogle(LocalDate createdAtAuthGoogle) {
        this.createdAtAuthGoogle = createdAtAuthGoogle;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
