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
    public List<TipoResenaDTO> listar(){
        return service.listarTipoResena().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, TipoResenaDTO.class);
        }).collect(Collectors.toList());
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
    public void insertar(@RequestBody TipoResenaDTO dto){
        ModelMapper m = new ModelMapper();
        TipoResena tr = m.map(dto, TipoResena.class);
        service.insert(tr);
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
