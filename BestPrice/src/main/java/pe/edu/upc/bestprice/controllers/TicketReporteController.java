package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TicketReporteDTOInsert;
import pe.edu.upc.bestprice.dtos.TicketReporteDTOList;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTOInsert;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.entities.TicketRespuesta;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketReporteService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketreporte")
public class TicketReporteController {

    @Autowired
    private ITicketReporteService reporteService;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<TicketReporteDTOList> lista = reporteService.listarTicketReporte()
                .stream()
                .map(a -> new ModelMapper().map(a, TicketReporteDTOList.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {

            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "No existen registros");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
    public void insertar(@RequestBody TicketReporteDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TicketReporte soft = m.map(dto,TicketReporte.class);
        reporteService.insertarTicketReporte(soft);
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> editar(@RequestBody TicketReporteDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TicketReporte ticketReporte = m.map(dto, TicketReporte.class);
        TicketReporte existente = reporteService.listarId(ticketReporte.getIdTicketRep());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ticketReporte.getIdTicketRep());
        }
        reporteService.edit(ticketReporte);
        return ResponseEntity.ok("Registro con ID " + ticketReporte.getIdTicketRep() + " modificado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TicketReporte tres = reporteService.listarId(id);
        if (tres == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TicketReporteDTOList dto = m.map(tres, TicketReporteDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        TicketReporte u = reporteService.listarId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        reporteService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
