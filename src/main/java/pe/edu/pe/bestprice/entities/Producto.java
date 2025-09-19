package pe.edu.pe.bestprice.entities;

import jakarta.persistence.*;

@Entity
@Table(name="Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    @Column(name = "NombreProducto", nullable = false, length = 25)
    private String NombreProducto;
    @Column(name = "DescripcionProducto", nullable = false, length = 150)
    private String DescripcionProducto;
    @Column(name = "MarcaProducto", nullable = false, length = 25)
    private String MarcaProducto;
    @Column(name = "PrecioProducto", nullable = false, length = 15)
    private double PrecioProducto;
    @Column(name = "StockProducto", nullable = false, length = 25)
    private int StockProducto;
    @Column(name = "NombreProducto", nullable = false, length = 20)
    private float UnidadMetricaProducto;
    @Column(name = "NombreProducto", nullable = false)
    private boolean FavoritoProducto;
    @Column(name = "NombreProducto", nullable = false)
    private boolean DisponibleProducto;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idTiendas")
    private Tiendas TiendasProducto;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCategoriaProducto")
    private CategoriaProducto CateProduct;

    public Producto() {
    }

    public Producto(int idProducto, String nombreProducto, String descripcionProducto, String marcaProducto, double precioProducto, int stockProducto, float unidadMetricaProducto, boolean favoritoProducto, boolean disponibleProducto, Tiendas tiendasProducto, CategoriaProducto cateProduct) {
        this.idProducto = idProducto;
        NombreProducto = nombreProducto;
        DescripcionProducto = descripcionProducto;
        MarcaProducto = marcaProducto;
        PrecioProducto = precioProducto;
        StockProducto = stockProducto;
        UnidadMetricaProducto = unidadMetricaProducto;
        FavoritoProducto = favoritoProducto;
        DisponibleProducto = disponibleProducto;
        TiendasProducto = tiendasProducto;
        CateProduct = cateProduct;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return DescripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        DescripcionProducto = descripcionProducto;
    }

    public String getMarcaProducto() {
        return MarcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        MarcaProducto = marcaProducto;
    }

    public double getPrecioProducto() {
        return PrecioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        PrecioProducto = precioProducto;
    }

    public int getStockProducto() {
        return StockProducto;
    }

    public void setStockProducto(int stockProducto) {
        StockProducto = stockProducto;
    }

    public float getUnidadMetricaProducto() {
        return UnidadMetricaProducto;
    }

    public void setUnidadMetricaProducto(float unidadMetricaProducto) {
        UnidadMetricaProducto = unidadMetricaProducto;
    }

    public boolean isFavoritoProducto() {
        return FavoritoProducto;
    }

    public void setFavoritoProducto(boolean favoritoProducto) {
        FavoritoProducto = favoritoProducto;
    }

    public boolean isDisponibleProducto() {
        return DisponibleProducto;
    }

    public void setDisponibleProducto(boolean disponibleProducto) {
        DisponibleProducto = disponibleProducto;
    }

    public Tiendas getTiendasProducto() {
        return TiendasProducto;
    }

    public void setTiendasProducto(Tiendas tiendasProducto) {
        TiendasProducto = tiendasProducto;
    }

    public CategoriaProducto getCateProduct() {
        return CateProduct;
    }

    public void setCateProduct(CategoriaProducto cateProduct) {
        CateProduct = cateProduct;
    }
}
