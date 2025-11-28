package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "LineaTienda")
public class LineaTienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLineaTienda;

    @Column(name = "nombreLineaTienda", length = 50, nullable = false)
    private String nombreLineaTienda;

    public LineaTienda() {
    }

    public LineaTienda(int idLineaTienda, String nombreLineaTienda) {
        this.idLineaTienda = idLineaTienda;
        this.nombreLineaTienda = nombreLineaTienda;
    }

    public int getIdLineaTienda() {
        return idLineaTienda;
    }

    public void setIdLineaTienda(int idLineaTienda) {
        this.idLineaTienda = idLineaTienda;
    }

    public String getNombreLineaTienda() {
        return nombreLineaTienda;
    }

    public void setNombreLineaTienda(String nombreLineaTienda) {
        this.nombreLineaTienda = nombreLineaTienda;
    }

}