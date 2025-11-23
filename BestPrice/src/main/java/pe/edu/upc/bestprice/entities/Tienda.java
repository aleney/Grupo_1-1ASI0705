package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
    @Column(name="nombreTienda", nullable = false, length = 50)
    private String nombreTienda;

    public Tienda() {
    }

    public Tienda(int idTienda, String nombreTienda, String detalleTienda, String numeroTelefono, boolean estadoTienda, LocalDate fechaTienda, TipoTienda tipoTienda, List<Producto> productosTienda) {
        this.idTienda = idTienda;
        this.nombreTienda = nombreTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
}