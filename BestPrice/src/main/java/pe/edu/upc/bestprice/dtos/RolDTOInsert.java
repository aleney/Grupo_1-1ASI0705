package pe.edu.upc.bestprice.dtos;

import java.time.LocalDateTime;

public class RolDTOInsert {
    private int idRol;
    private String tipoUsuario;

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

}
