package pe.edu.upc.BestPrice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "nombreProducto", nullable = false, length = 25)
    private String nombreProducto;
    @Column(name = "descripcionProducto", nullable = false, length = 150)
    private String descripcionProducto;
    @Column(name = "marcaProducto", nullable = false, length = 25)
    private String marcaProducto;
    @Column(name = "precioProducto", nullable = false, length = 15)
    private double precioProducto;
    @Column(name = "stockProducto", nullable = false, length = 25)
    private int stockProducto;
    @Column(name = "unidadMetricaProducto", nullable = false, length = 20)
    private float unidadMetricaProducto;
    @Column(name = "favoritoProducto", nullable = false)
    private boolean favoritoProducto;
    @Column(name = "disponibleProducto", nullable = false)
    private boolean disponibleProducto;

    @ManyToOne
    @JoinColumn(name="idTiendas")
    private Tiendas tiendas;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, String marcaProducto, double precioProducto, int stockProducto, float unidadMetricaProducto, boolean favoritoProducto, boolean disponibleProducto, Tiendas tiendas) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.marcaProducto = marcaProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.unidadMetricaProducto = unidadMetricaProducto;
        this.favoritoProducto = favoritoProducto;
        this.disponibleProducto = disponibleProducto;
        this.tiendas = tiendas;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(int stockProducto) {
        this.stockProducto = stockProducto;
    }

    public float getUnidadMetricaProducto() {
        return unidadMetricaProducto;
    }

    public void setUnidadMetricaProducto(float unidadMetricaProducto) {
        this.unidadMetricaProducto = unidadMetricaProducto;
    }

    public boolean isFavoritoProducto() {
        return favoritoProducto;
    }

    public void setFavoritoProducto(boolean favoritoProducto) {
        this.favoritoProducto = favoritoProducto;
    }

    public boolean isDisponibleProducto() {
        return disponibleProducto;
    }

    public void setDisponibleProducto(boolean disponibleProducto) {
        this.disponibleProducto = disponibleProducto;
    }

    public Tiendas getTiendas() {
        return tiendas;
    }

    public void setTiendas(Tiendas tiendas) {
        this.tiendas = tiendas;
    }
}
