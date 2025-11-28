package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TicketReporteDTOInsert;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTOInsert;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTOList;
import pe.edu.upc.bestprice.dtos.UsuarioDTOList;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.entities.TicketRespuesta;
import pe.edu.upc.bestprice.entities.Usuario;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketRespuestaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketrespuesta")
public class TicketRespuestaController {

    @Autowired
    private ITicketRespuestaService respuestaService;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN')")
    public ResponseEntity<?> listar() {
        List<TicketRespuesta> lista = respuestaService.listarTicketRespuesta()
                .stream()
                .map(a -> new ModelMapper().map(a, TicketRespuesta.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {

            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "No existen registros");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }

        return ResponseEntity.ok(lista);
    }


    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody TicketRespuestaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TicketRespuesta soft = m.map(dto,TicketRespuesta.class);
        respuestaService.insertarTicketRespuesta(soft);
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> editar(@RequestBody TicketRespuestaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TicketRespuesta ticketRespuesta = m.map(dto, TicketRespuesta.class);
        TicketRespuesta existente = respuestaService.listarId(ticketRespuesta.getIdTicketRes());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ticketRespuesta.getIdTicketRes());
        }
        respuestaService.edit(ticketRespuesta);
        return ResponseEntity.ok("Registro con ID " + ticketRespuesta.getIdTicketRes() + " modificado correctamente.");
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TicketRespuesta tres = respuestaService.listarId(id);
        if (tres == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TicketRespuestaDTOList dto = m.map(tres, TicketRespuestaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        TicketRespuesta u = respuestaService.listarId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        respuestaService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
