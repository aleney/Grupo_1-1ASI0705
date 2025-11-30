package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiporesena")
public class TipoResenaController {

    @Autowired
    private ITipoResenaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> listar() {
        List<TipoResenaDTO> lista = service.getAllTipoResena().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TipoResenaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tipos de resenias registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    // ---------------------------
    // GET: por ID
    // ---------------------------
    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TipoResena tr = service.getTipoResenaById(id);
        if (tr == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipoResenaDTO dto = m.map(tr, TipoResenaDTO.class);
        return ResponseEntity.ok(dto);
    }

    // ---------------------------
    // POST: crear (usa DTOInsert)
    // ---------------------------
    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody TipoResenaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            TipoResena tr = m.map(dto, TipoResena.class);
            service.createTipoResena(tr);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Línea de tienda registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la línea de tienda. Verifica que los datos enviados sean correctos.");
        }
    }

    // ---------------------------
    // PUT: actualizar (usa DTOInsert)
    // ---------------------------
    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody TipoResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoResena tr = m.map(dto, TipoResena.class);

        // Validación de existencia
        TipoResena existente = service.getTipoResenaById(tr.getIdTipoResena());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tr.getIdTipoResena());
        }

        // Actualización si pasa validaciones
        service.updateTipoResena(tr);
        return ResponseEntity.ok("Registro con ID " + tr.getIdTipoResena() + " modificado correctamente.");
    }

    // ---------------------------
    // DELETE: eliminar por ID
    // ---------------------------
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoResena tr = service.getTipoResenaById(id);
        if (tr == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.deleteTipoResena(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @GetMapping("/buscarnombre")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<TipoResena> tr = service.findByTipoResena(n);

        if (tr.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tiendas de nombre o caracter: " + n);
        }

        List<TipoResenaDTO> listaDTO = tr.stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TipoResenaDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }
}
