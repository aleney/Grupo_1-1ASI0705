package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
}