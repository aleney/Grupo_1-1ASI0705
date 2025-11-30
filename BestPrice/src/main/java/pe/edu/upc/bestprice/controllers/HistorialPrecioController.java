package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.HistorialPrecioDTO;
import pe.edu.upc.bestprice.entities.HistorialPrecio;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialPrecioService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historial-precio")
public class HistorialPrecioController {
    @Autowired
    private IHistorialPrecioService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> listar() {
        List<HistorialPrecioDTO> lista = service.list().stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron historiales de precios registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<String> insertar(@RequestBody HistorialPrecioDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            HistorialPrecio hp = m.map(dto, HistorialPrecio.class);
            service.insert(hp);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Historial de precio registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el historial de precio. Verifica que los datos enviados sean correctos.");
        }
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        HistorialPrecio hp = service.listId(id);
        if (hp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un historial con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        return ResponseEntity.ok(m.map(hp, HistorialPrecioDTO.class));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        HistorialPrecio hp = service.listId(id);
        if (hp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un historial con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Historial con ID " + id + " eliminado correctamente.");
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody HistorialPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        HistorialPrecio hp = m.map(dto, HistorialPrecio.class);
        HistorialPrecio existente = service.listId(hp.getIdHistorialPrecio());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un historial con ID: " + hp.getIdHistorialPrecio());
        }
        service.edit(hp);
        return ResponseEntity.ok("Historial con ID " + hp.getIdHistorialPrecio() + " modificado correctamente.");
    }

    @GetMapping("/{idProducto}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<HistorialPrecioDTO> buscarPorProducto(@PathVariable("idProducto") int idProducto) {
        return service.buscarPorProducto(idProducto).stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{fecha}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public List<HistorialPrecioDTO> buscarPorFecha(@PathVariable("fecha") String fecha) {
        LocalDate fechaConvertida = LocalDate.parse(fecha); // formato yyyy-MM-dd
        return service.buscarPorFecha(fechaConvertida).stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());
    }
}
