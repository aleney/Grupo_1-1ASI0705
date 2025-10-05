package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TiendaDTO;
import pe.edu.upc.bestprice.entities.Tienda;
import pe.edu.upc.bestprice.serviceinterfaces.ITiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tienda")
public class TiendaController {

    @Autowired
    private ITiendaService service;

    @GetMapping("/listarTienda")
    public ResponseEntity<?> listarTienda() {
        List<TiendaDTO> lista = service.listarTienda().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TiendaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tiendas registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/registrarTienda")
    public ResponseEntity<String> registrarTienda(@RequestBody TiendaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            Tienda tienda = m.map(dto, Tienda.class);
            service.insert(tienda);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Tienda registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la tienda. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTienda(@PathVariable("id") Integer id) {
        Tienda tdtos = service.listarIdTienda(id);
        if (tdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de Tienda" + id);
        }
        ModelMapper m = new ModelMapper();
        TiendaDTO tdt = m.map(tdtos, TiendaDTO.class);
        return ResponseEntity.ok(tdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tienda td = service.listarIdTienda(id);
        if (td == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        Tienda existente = service.listarIdTienda(t.getIdTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + t.getIdTienda());
        }

        // Actualización si pasa validaciones
        service.update(t);
        return ResponseEntity.ok("Registro con ID " + t.getIdTienda() + " modificado correctamente.");
    }

}
