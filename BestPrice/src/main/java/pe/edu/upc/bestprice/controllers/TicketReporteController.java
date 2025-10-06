package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.RolDTO;
import pe.edu.upc.bestprice.dtos.TicketReporteDTO;
import pe.edu.upc.bestprice.dtos.UsuarioDTOInsert;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.entities.Usuario;
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
        List<TicketReporteDTO> lista = reporteService.listarTicketReporte()
                .stream()
                .map(a -> new ModelMapper().map(a, TicketReporteDTO.class))
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
    public void insertar(@RequestBody TicketReporteDTO dto) {
        ModelMapper m = new ModelMapper();
        TicketReporte soft = m.map(dto,TicketReporte.class);
        reporteService.insertarTicketReporte(soft);
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> editar(@RequestBody TicketReporteDTO dto) {
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
}
