package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.CanastaDTO;
import pe.edu.upc.bestprice.entities.Canasta;
import pe.edu.upc.bestprice.serviceinterfaces.ICanastaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/canastas")
public class CanastaController {
    @Autowired
    @Qualifier("CanastaServiceImplement")
    private ICanastaService service;

    // Listar todas las canastas
    @GetMapping
    public List<CanastaDTO> listar() {
        return service.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, CanastaDTO.class);
        }).collect(Collectors.toList());
    }

    // Insertar una nueva canasta
    @PostMapping
    public ResponseEntity<String> insertar(@RequestBody CanastaDTO dto) {
        ModelMapper m = new ModelMapper();
        Canasta canasta = m.map(dto, Canasta.class);
        service.insert(canasta);
        return ResponseEntity.status(HttpStatus.CREATED).body("Canasta creada correctamente.");
    }

    // Obtener una canasta por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Canasta cana = service.listId(id);
        if (cana == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        CanastaDTO dto = m.map(cana, CanastaDTO.class);
        return ResponseEntity.ok(dto);
    }

    // Eliminar una canasta
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Canasta canasta = service.listId(id);
        if (canasta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    // Actualizar una canasta
    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody CanastaDTO dto) {
        ModelMapper m = new ModelMapper();
        Canasta c = m.map(dto, Canasta.class);
        Canasta existente = service.listId(c.getIdCanasta());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + c.getIdCanasta());
        }
        service.edit(c);
        return ResponseEntity.ok("Registro con ID " + c.getIdCanasta() + " modificado correctamente.");
    }

    // Buscar canasta por usuario
    @GetMapping("/busquedas")
    public ResponseEntity<?> buscar(@RequestParam String usuario) {
        List<Canasta> canastas = service.buscarService(usuario);
        if (canastas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron canastas para el usuario: " + usuario);
        }
        List<CanastaDTO> canastaDTOS = canastas.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CanastaDTO.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(canastaDTOS);
    }
}
