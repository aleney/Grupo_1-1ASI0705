package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.HistorialBusquedaDTO;
import pe.edu.upc.bestprice.entities.Distrito;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial-busqueda")
public class HistorialBusquedaController {

    @Autowired
    private IHistorialBusquedaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<HistorialBusquedaDTO> lista = service.list().stream().map(hb -> {
            ModelMapper m = new ModelMapper();
            return m.map(hb, HistorialBusquedaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron historiales de búsqueda registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT','SELLER')")
    public ResponseEntity<String> insertar(@RequestBody HistorialBusquedaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            HistorialBusqueda hb = m.map(dto, HistorialBusqueda.class);
            service.insert(hb);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Historial de búsqueda registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el historial de búsqueda. Verifica que los datos enviados sean correctos.");
        }
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        HistorialBusqueda historialBusqueda = service.listId(id);
        if (historialBusqueda == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        HistorialBusquedaDTO dto = m.map(historialBusqueda, HistorialBusquedaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        HistorialBusqueda hb = service.listId(id);
        if (hb == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

}
