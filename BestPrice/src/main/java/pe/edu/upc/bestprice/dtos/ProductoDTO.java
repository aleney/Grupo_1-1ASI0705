package pe.edu.upc.bestprice.dtos;

import pe.edu.upc.bestprice.entities.CategoriaProducto;
import pe.edu.upc.bestprice.entities.Tienda;

public class ProductoDTO {

    private int idProducto;
    private String NombreProducto;
    private String DetalleProducto;
    private String MarcaProducto;
    private double PrecioProducto;
    private int StockProducto;
    private String UnidadMetricaProducto;
    private boolean FavoritoProducto;
    private boolean DisponibleProducto;
    private Tienda TiendaProducto;
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

    public String getDetalleProducto() {
        return DetalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        DetalleProducto = detalleProducto;
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

    public String getUnidadMetricaProducto() {
        return UnidadMetricaProducto;
    }

    public void setUnidadMetricaProducto(String unidadMetricaProducto) {
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

    public Tienda getTiendaProducto() {
        return TiendaProducto;
    }

    public void setTiendaProducto(Tienda TiendaProducto) {
        TiendaProducto = TiendaProducto;
    }

    public CategoriaProducto getCateProduct() {
        return CateProduct;
    }

    public void setCateProduct(CategoriaProducto cateProduct) {
        CateProduct = cateProduct;
    }
}
