package pe.edu.upc.bestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

@Repository
public interface ICanastaDetalleRepository extends JpaRepository<CanastaDetalle,String> {
    //public List<CanastaDetalle>list();
    //public void insert(CanastaDetalle cd);
    //public List<CanastaDetalle> buscar(String id);
    //public List<CanastaDetalle> findAll(String nombre);
}
