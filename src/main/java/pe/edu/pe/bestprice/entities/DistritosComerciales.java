package pe.edu.pe.bestprice.entities;
import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="DistritoComercial")
public class DistritosComerciales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "NombreDistritoC",length = 20,nullable = false)
    private String distrito_Nombre;
    @Column(name="DescripciónDistritoC",length = 20,nullable = false)
    private String descripcion_Distrito;
    @Column(name = "LongitudDistritoC",length = 20,nullable = false)
    private double longitud;
    @Column(name="latitudDistritoC",length = 20,nullable = false)
    private double latitud;
    @Column(name="FechaCreación",nullable = false)
    private Timestamp FechaCreación;

   /* @OneToMany(mappedBy = "UbicacionTienda",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<UbicacionTienda> UbicaciónTienda; */

    public DistritosComerciales() {
    }

    public DistritosComerciales(int id, String distrito_Nombre, String descripcion_Distrito, double longitud, double latitud, Timestamp fechaCreación/*, List<pe.edu.pe.bestprice.entities.UbicacionTienda> ubicaciónTienda*/) {
        this.id = id;
        this.distrito_Nombre = distrito_Nombre;
        this.descripcion_Distrito = descripcion_Distrito;
        this.longitud = longitud;
        this.latitud = latitud;
        FechaCreación = fechaCreación;
       // UbicaciónTienda = ubicaciónTienda;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrito_Nombre() {
        return distrito_Nombre;
    }

    public void setDistrito_Nombre(String distrito_Nombre) {
        this.distrito_Nombre = distrito_Nombre;
    }

    public String getDescripcion_Distrito() {
        return descripcion_Distrito;
    }

    public void setDescripcion_Distrito(String descripcion_Distrito) {
        this.descripcion_Distrito = descripcion_Distrito;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public Timestamp getFechaCreación() {
        return FechaCreación;
    }

    public void setFechaCreación(Timestamp fechaCreación) {
        FechaCreación = fechaCreación;
    }
}
