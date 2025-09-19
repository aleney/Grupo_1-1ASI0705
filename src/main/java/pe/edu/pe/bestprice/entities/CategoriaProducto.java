package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="CategoriaProducto")
public class CategoriaProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoriaProducto;
}
