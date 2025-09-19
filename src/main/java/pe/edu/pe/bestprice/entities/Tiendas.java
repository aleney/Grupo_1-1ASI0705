package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Tiendas")
public class Tiendas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTiendas;
}
