package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.UbicacionTiendaDTOInsert;
import pe.edu.upc.bestprice.dtos.UbicacionTiendaDTOList;
import pe.edu.upc.bestprice.entities.UbicacionTienda;
import pe.edu.upc.bestprice.serviceinterfaces.IUbicacionTiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ubicacion-tienda")
public class UbicacionTiendaController {
    @Autowired
    private IUbicacionTiendaService service;

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    @GetMapping
    public List<UbicacionTiendaDTOList> listar() {
        return service.list().stream().map(u -> {
            ModelMapper m = new ModelMapper();
            return m.map(u, UbicacionTiendaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER')")
    @PostMapping("/insertar")
    public void insertar(@RequestBody UbicacionTiendaDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        UbicacionTienda u = m.map(dto, UbicacionTienda.class);
        service.insert(u);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        UbicacionTienda u = service.listId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe una ubicación con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UbicacionTiendaDTOList dto = m.map(u, UbicacionTiendaDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER')")
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

    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER')")
    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody UbicacionTiendaDTOInsert dto) {
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
