package pe.edu.pe.bestprice.dtos;
import jakarta.persistence.Column;
import pe.edu.pe.bestprice.entities.CategoriaProducto;
import pe.edu.pe.bestprice.entities.Tiendas;

public class ProductoDTO {

    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private String marcaProducto;
    private double precioProducto;
    private int stockProducto;
    private float unidadMetricaProducto;
    private boolean favoritoProducto;
    private boolean disponibleProducto;
    private Tiendas tiendas;

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
