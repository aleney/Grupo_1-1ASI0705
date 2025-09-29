package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public List<UbicacionTiendaDTO> listar() {
        return service.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UbicacionTiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody UbicacionTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        UbicacionTienda u = m.map(dto, UbicacionTienda.class);
        service.insert(u);
    }

    @GetMapping("/{id}")
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
