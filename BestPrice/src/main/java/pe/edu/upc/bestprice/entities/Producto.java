package pe.edu.upc.bestprice.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "nombreProducto", nullable = false, length = 25)
    private String nombreProducto;

    @Column(name = "detalleProducto", nullable = true, length = 250)
    private String detalleProducto;

    @Column(name = "marcaProducto", nullable = false, length = 25)
    private String marcaProducto;

    @Column(name = "precioProducto", nullable = false, length = 15)
    private double precioProducto;

    @Column(name = "stockProducto", nullable = false, length = 25)
    private int stockProducto;

    @Column(name = "unidadMetricaProducto", nullable = false, length = 20)
    private String unidadMetricaProducto;

    @Column(name = "favoritoProducto", nullable = true)
    private boolean favoritoProducto;

    @Column(name = "disponibleProducto", nullable = false)
    private boolean disponibleProducto;

    @CreationTimestamp
    @Column(name="createdAt",nullable=true, updatable=false)
    private LocalDateTime createdAtProducto;

    @UpdateTimestamp
    @Column(name="updatedAt",nullable=true)
    private LocalDateTime updatedAtProducto;

    @ManyToOne
    @JoinColumn(name = "idCategoriaProducto")
    private CategoriaProducto cateProduct;

    @ManyToOne
    @JoinColumn(name = "idtienda")
    private Tienda tienda;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String detalleProducto, String marcaProducto, double precioProducto, int stockProducto, String unidadMetricaProducto, boolean favoritoProducto, boolean disponibleProducto, LocalDateTime createdAt, LocalDateTime updatedAt, CategoriaProducto cateProduct, Tienda tienda) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.detalleProducto = detalleProducto;
        this.marcaProducto = marcaProducto;
        this.precioProducto = precioProducto;
        this.stockProducto = stockProducto;
        this.unidadMetricaProducto = unidadMetricaProducto;
        this.favoritoProducto = favoritoProducto;
        this.disponibleProducto = disponibleProducto;
        this.cateProduct = cateProduct;
        this.tienda = tienda;
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

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
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

    public String getUnidadMetricaProducto() {
        return unidadMetricaProducto;
    }

    public void setUnidadMetricaProducto(String unidadMetricaProducto) {
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

    public LocalDateTime getCreatedAtProducto() {
        return createdAtProducto;
    }

    public void setCreatedAtProducto(LocalDateTime createdAtProducto) {
        this.createdAtProducto = createdAtProducto;
    }

    public LocalDateTime getUpdatedAtProducto() {
        return updatedAtProducto;
    }

    public void setUpdatedAtProducto(LocalDateTime updatedAtProducto) {
        this.updatedAtProducto = updatedAtProducto;
    }

    public CategoriaProducto getCateProduct() {
        return cateProduct;
    }

    public void setCateProduct(CategoriaProducto cateProduct) {
        this.cateProduct = cateProduct;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }
}
