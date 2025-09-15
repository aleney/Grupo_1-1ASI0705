package pe.edu.pe.bestprice.dtos;

import pe.edu.pe.bestprice.entities.Usuario;

public class AuthGoogleDTOList {
    private String nombreAuthGoogle;
    private String emailAuthGoogle;
    private Usuario usuario;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
