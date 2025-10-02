package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleRepository extends JpaRepository<CanastaDetalle,String> {
    public List<CanastaDetalle>list();
    public void insert(CanastaDetalle cd);
    public List<CanastaDetalle> buscar(String id);

}
