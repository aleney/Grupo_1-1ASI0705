package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TipoReseña")
public class TipoReseña {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoReseña;

    @Column(name = "tiporeseTipoReseña",length = 50,nullable = false)
    private String tiporeseTipoReseña;

    public TipoReseña() {
    }

    public TipoReseña(int idTipoReseña, String tiporeseTipoReseña) {
        this.idTipoReseña = idTipoReseña;
        this.tiporeseTipoReseña = tiporeseTipoReseña;
    }

    public int getIdTipoReseña() {
        return idTipoReseña;
    }

    public void setIdTipoReseña(int idTipoReseña) {
        this.idTipoReseña = idTipoReseña;
    }

    public String getTiporeseTipoReseña() {
        return tiporeseTipoReseña;
    }

    public void setTiporeseTipoReseña(String tiporeseTipoReseña) {
        this.tiporeseTipoReseña = tiporeseTipoReseña;
    }
}
