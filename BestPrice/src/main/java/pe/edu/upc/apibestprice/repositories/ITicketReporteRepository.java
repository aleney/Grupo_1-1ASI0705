package pe.edu.upc.apibestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apibestprice.entities.TicketReporte;

@Repository
public interface ITicketReporteRepository extends JpaRepository<TicketReporte,Integer> {
}
