package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.RolDTO;
import pe.edu.upc.bestprice.dtos.TicketRespuestaDTO;
import pe.edu.upc.bestprice.entities.TicketRespuesta;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketRespuestaService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketrespuesta")
public class TicketRespuestaController {

    @Autowired
    private ITicketRespuestaService reporteService;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('CLIENT','ADMIN')")
    public ResponseEntity<?> listar() {
        List<TicketRespuesta> lista = reporteService.listarTicketRespuesta()
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
    public void insertar(@RequestBody TicketRespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        TicketRespuesta soft = m.map(dto,TicketRespuesta.class);
        reporteService.insertarTicketRespuesta(soft);
    }
}
