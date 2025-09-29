package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table
public class TipoResena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoResena;

    public TipoResena() {
    }

    public TipoResena(int idTipoResena) {
        this.idTipoResena = idTipoResena;
    }

    public int getIdTipoResena() {
        return idTipoResena;
    }

    public void setIdTipoResena(int idTipoResena) {
        this.idTipoResena = idTipoResena;
    }
}