package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String NombreProducto;
    private String DescripcionProducto;
    private String MarcaProducto;
    private double PrecioProducto;
    private int StockProducto;
    private float UnidadMetricaProducto;
    private boolean FavoritoProducto;
    private boolean DisponibleProducto;

}
