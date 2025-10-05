package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTO;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTO;
import pe.edu.upc.bestprice.entities.TicketRespuesta;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketRespuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket-respuesta")
public class TicketRespuestaController {

    @Autowired
    private ITicketRespuestaService reporteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<TicketRespuestaDTO> lista = reporteService.listarTicketRespuesta().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TicketRespuestaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron roles registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertar(@RequestBody TicketRespuestaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            TicketRespuesta soft = m.map(dto, TicketRespuesta.class);
            reporteService.insertarTicketRespuesta(soft);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ticket de respuesta registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el ticket de respuesta. Verifica que los datos enviados sean correctos.");
        }
    }

}
