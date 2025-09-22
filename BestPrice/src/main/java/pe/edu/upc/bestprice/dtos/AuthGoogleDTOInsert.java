package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Usuario;

import java.time.LocalDate;

public class AuthGoogleDTOInsert {
    private int idAuthGoogle;
    private String nombreAuthGoogle;
    private String emailAuthGoogle;
    private String contrasenaAuthGoogle;
    private LocalDate createdAtAuthGoogle;
    private Usuario usuario;

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
