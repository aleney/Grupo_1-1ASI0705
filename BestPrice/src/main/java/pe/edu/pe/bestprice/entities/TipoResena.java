package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table
public class TipoResena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoResena;
}
