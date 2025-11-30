package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "TipoResena")
public class TipoResena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoResena;

    @Column(name = "tiporeseTipoResena",length = 50,nullable = false)
    private String tiporeseTipoResena;

    public TipoResena() {
    }

    public TipoResena(int idTipoResena, String tiporeseTipoResena) {
        this.idTipoResena = idTipoResena;
        this.tiporeseTipoResena = tiporeseTipoResena;
    }

    public int getIdTipoResena() {
        return idTipoResena;
    }

    public void setIdTipoResena(int idTipoResena) {
        this.idTipoResena = idTipoResena;
    }

    public String getTiporeseTipoResena() {
        return tiporeseTipoResena;
    }

    public void setTiporeseTipoResena(String tiporeseTipoResena) {
        this.tiporeseTipoResena = tiporeseTipoResena;
    }
}
