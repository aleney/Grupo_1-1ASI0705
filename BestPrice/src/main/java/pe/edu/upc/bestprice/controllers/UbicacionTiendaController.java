package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.UbicacionTiendaDTO;
import pe.edu.upc.bestprice.entities.UbicacionTienda;
import pe.edu.upc.bestprice.serviceinterfaces.IUbicacionTiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicacion-tienda")
public class UbicacionTiendaController {
    @Autowired
    private IUbicacionTiendaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> listar() {
        List<UbicacionTiendaDTO> lista = service.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UbicacionTiendaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron ubicaciones de tienda registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<String> insertar(@RequestBody UbicacionTiendaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            UbicacionTienda u = m.map(dto, UbicacionTienda.class);
            service.insert(u);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Ubicación de tienda registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la ubicación de tienda. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        UbicacionTienda u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una ubicación con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UbicacionTiendaDTO dto = m.map(u, UbicacionTiendaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        UbicacionTienda u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una ubicación con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Ubicación con ID " + id + " eliminada correctamente.");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody UbicacionTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        UbicacionTienda u = m.map(dto, UbicacionTienda.class);
        UbicacionTienda existente = service.listId(u.getIdUbicacionTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe una ubicación con el ID: " + u.getIdUbicacionTienda());
        }
        service.edit(u);
        return ResponseEntity.ok("Ubicación con ID " + u.getIdUbicacionTienda() + " modificada correctamente.");
    }
}
