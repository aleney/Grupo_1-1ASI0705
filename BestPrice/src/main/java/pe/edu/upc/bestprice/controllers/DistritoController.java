package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.DistritoDTOInsert;
import pe.edu.upc.bestprice.dtos.DistritoDTOList;
import pe.edu.upc.bestprice.entities.Distrito;
import pe.edu.upc.bestprice.serviceinterfaces.IDistritoService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/distrito")
public class DistritoController {

    @Autowired
    private IDistritoService service;

    // LISTAR
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    @GetMapping("/listar")
    public List<DistritoDTOList> listar() {
        ModelMapper m = new ModelMapper();
        return service.list().stream()
                .map(d -> m.map(d, DistritoDTOList.class))
                .toList();
    }

    // INSERTAR
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(@RequestBody DistritoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Distrito distrito = m.map(dto, Distrito.class);

        // --- CLAVE PARA QUE NO SE ROMPA EL INSERT ---
        if (distrito.getCreatedAtDistrito() == null) {
            distrito.setCreatedAtDistrito(LocalDateTime.now());
        }

        service.insert(distrito);
        return ResponseEntity.status(HttpStatus.CREATED).body("Distrito registrado correctamente.");
    }

    // LISTAR POR ID
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Distrito distrito = service.listId(id);
        if (distrito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        ModelMapper m = new ModelMapper();
        DistritoDTOList dto = m.map(distrito, DistritoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    // ELIMINAR
    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Distrito distrito = service.listId(id);
        if (distrito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }

        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // MODIFICAR
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody DistritoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Distrito distrito = m.map(dto, Distrito.class);

        Distrito existente = service.listId(distrito.getIdDistrito());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + distrito.getIdDistrito());
        }

        // Mantener la fecha original sin modificarla
        distrito.setCreatedAtDistrito(existente.getCreatedAtDistrito());

        service.edit(distrito);
        return ResponseEntity.ok("Registro con ID " + distrito.getIdDistrito() + " modificado correctamente.");
    }
}
