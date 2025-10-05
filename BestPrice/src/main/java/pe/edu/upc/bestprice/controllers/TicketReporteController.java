package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TicketReporteDTO;
import pe.edu.upc.bestprice.dtos.TicketReporteDTO;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketReporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket-reporte")
public class TicketReporteController {

    @Autowired
    private ITicketReporteService reporteService;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<TicketReporteDTO> lista = reporteService.listarTicketReporte().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TicketReporteDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron roles registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertar(@RequestBody TicketReporteDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            TicketReporte soft = m.map(dto, TicketReporte.class);
            reporteService.insertarTicketReporte(soft);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ticket de reporte registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el ticket de reporte. Verifica que los datos enviados sean correctos.");
        }
    }

}
