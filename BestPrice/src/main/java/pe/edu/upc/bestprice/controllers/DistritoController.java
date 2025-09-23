package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.DistritoDTO;
import pe.edu.upc.bestprice.entities.Distrito;
import pe.edu.upc.bestprice.serviceinterfaces.IDistritoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private IDistritoService service;

    @GetMapping("/listar")
    public List<DistritoDTO> listar() {
        return service.list().stream().map(d -> {
            ModelMapper m = new ModelMapper();
            return m.map(d, DistritoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito distrito = m.map(dto, Distrito.class);
        service.insert(distrito);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Distrito distrito = service.listId(id);
        if (distrito == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID:" + id);
        }
        ModelMapper m = new ModelMapper();
        DistritoDTO dto = m.map(distrito, DistritoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Distrito d = service.listId(id);
        if (d == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody DistritoDTO dto) {
        ModelMapper m = new ModelMapper();
        Distrito d = m.map(dto, Distrito.class);
        Distrito existente = service.listId(d.getIdDistrito());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + d.getIdDistrito());
        }
        service.edit(d);
        return ResponseEntity.ok("Registro con ID " + d.getIdDistrito() + " modificado correctamente.");
    }
}
