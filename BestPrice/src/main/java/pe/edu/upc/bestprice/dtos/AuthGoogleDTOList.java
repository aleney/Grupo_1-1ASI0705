package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.Usuario;

public class AuthGoogleDTOList {
    private String nombreAuthGoogle;
    private String emailAuthGoogle;
    private int idUsuario;

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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
