package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TipoTienda")
public class TipoTienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoTienda;
}
