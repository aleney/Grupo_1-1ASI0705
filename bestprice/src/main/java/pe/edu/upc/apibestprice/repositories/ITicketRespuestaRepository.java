package pe.edu.upc.apibestprice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.apibestprice.entities.TicketRespuesta;

@Repository
public interface ITicketRespuestaRepository extends JpaRepository<TicketRespuesta,Integer> {
}
