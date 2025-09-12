package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Ubicación Tienda")
public class UbicacionTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
