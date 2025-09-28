package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;

    public Tienda() {
    }

    public Tienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }
}