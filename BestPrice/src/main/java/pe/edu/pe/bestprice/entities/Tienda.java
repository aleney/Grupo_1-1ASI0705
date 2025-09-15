package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTienda;
}
