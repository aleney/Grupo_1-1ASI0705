package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.ResenaDTOInsert;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceimplements.TipoResenaServiceImplement;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo-resena")
public class TipoResenaController {

    @Autowired
    private TipoResenaServiceImplement service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<TipoResenaDTO> lista = service.listarTipoResena().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TipoResenaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tipos de reseña registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        TipoResena tr = service.ListId(id);
        if (tr == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        TipoResenaDTO dto = m.map(tr, TipoResenaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertar(@RequestBody TipoResenaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            TipoResena tr = m.map(dto, TipoResena.class);
            service.insert(tr);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Tipo de reseña registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el tipo de reseña. Verifica que los datos enviados sean correctos.");
        }
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody ResenaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        TipoResena tr = m.map(dto, TipoResena.class);

        // Validación de existencia
        TipoResena existente = service.ListId(tr.getIdTipoResena());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tr.getIdTipoResena());
        }
        // Actualización si pasa validaciones
        service.update(tr);
        return ResponseEntity.ok("Registro con ID " + tr.getIdTipoResena() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoResena r = service.ListId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
