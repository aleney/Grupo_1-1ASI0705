package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.CategoriaProducto;
import pe.edu.upc.bestprice.entities.Tiendas;

public class ProductoDTO {

    private int idProducto;
    private String NombreProducto;
    private String DescripcionProducto;
    private String MarcaProducto;
    private double PrecioProducto;
    private int StockProducto;
    private float UnidadMetricaProducto;
    private boolean FavoritoProducto;
    private boolean DisponibleProducto;
    private Tiendas TiendasProducto;
    private CategoriaProducto CateProduct;

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
