package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoTienda")
public class TipoTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoTienda;
    @Column(name ="nombreTipoTienda", nullable = false, length = 50)
    private String nombreTipoTienda;

    @OneToOne
    @JoinColumn(name="idTiendas")
    private Tiendas tiendas;

    public TipoTienda() {
    }

    public TipoTienda(int idTipoTienda, String nombreTipoTienda, Tiendas tiendas) {
        this.idTipoTienda = idTipoTienda;
        this.nombreTipoTienda = nombreTipoTienda;
        this.tiendas = tiendas;
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

    public Tiendas getTiendas() {
        return tiendas;
    }

    public void setTiendas(Tiendas tiendas) {
        this.tiendas = tiendas;
    }
}
