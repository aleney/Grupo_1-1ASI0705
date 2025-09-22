package pe.edu.upc.apibestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"idUsuario", "tipoUsuario"})})

public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "tipoUsuario",length = 20, nullable = false)
    private String tipoUsuario;

    public Rol(int idRol, String tipoUsuario) {
        this.idRol = idRol;
        this.tipoUsuario = tipoUsuario;
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


}
