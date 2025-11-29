package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<HistorialPrecioDTO> listar() {
        return service.list().stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody HistorialPrecioDTO dto) {
        ModelMapper m = new ModelMapper();
        HistorialPrecio hp = m.map(dto, HistorialPrecio.class);
        service.insert(hp);
    }

    @GetMapping("/{id}")
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
    public List<HistorialPrecioDTO> buscarPorProducto(@PathVariable("idProducto") int idProducto) {
        return service.buscarPorProducto(idProducto).stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/{fecha}")
    public List<HistorialPrecioDTO> buscarPorFecha(@PathVariable("fecha") String fecha) {
        LocalDate fechaConvertida = LocalDate.parse(fecha); // formato yyyy-MM-dd
        return service.buscarPorFecha(fechaConvertida).stream().map(hp -> {
            ModelMapper m = new ModelMapper();
            return m.map(hp, HistorialPrecioDTO.class);
        }).collect(Collectors.toList());
    }
}
