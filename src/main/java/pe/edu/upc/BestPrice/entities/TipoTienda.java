package pe.edu.upc.BestPrice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoTienda")
public class TipoTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoTienda;
    @Column(name ="nombreTipoTienda", nullable = false, length = 50)
    private String nombreTipoTienda;

    public TipoTienda() {
    }

    public TipoTienda(int idTipoTienda, String nombreTipoTienda) {
        this.idTipoTienda = idTipoTienda;
        this.nombreTipoTienda = nombreTipoTienda;
    }

    public int getIdTipoTienda() {
        return idTipoTienda;
    }

    public void setIdTipoTienda(int idTipoTienda) {
        this.idTipoTienda = idTipoTienda;
    }

    public String getNombreTipoTienda() {
        return nombreTipoTienda;
    }

    public void setNombreTipoTienda(String nombreTipoTienda) {
        this.nombreTipoTienda = nombreTipoTienda;
    }
}
