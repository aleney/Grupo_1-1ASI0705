package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.OfertasProductoDTOInsert;
import pe.edu.upc.bestprice.dtos.OfertasProductoDTOList;
import pe.edu.upc.bestprice.entities.OfertasProducto;
import pe.edu.upc.bestprice.serviceinterfaces.IOfertasProductoService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ofertas-producto")
public class OfertasProductoController {
    @Autowired
    private IOfertasProductoService service;

    @GetMapping("/listar")
    public List<OfertasProductoDTOList> listar() {
        return service.list().stream().map(o -> {
            ModelMapper m = new ModelMapper();
            return m.map(o, OfertasProductoDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody OfertasProductoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        OfertasProducto op = m.map(dto, OfertasProducto.class);
        service.insert(op);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        OfertasProducto op = service.listId(id);
        if (op == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe oferta con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        OfertasProductoDTOList dto = m.map(op, OfertasProductoDTOList.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        OfertasProducto op = service.listId(id);
        if (op == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe oferta con ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Oferta con ID " + id + " eliminada correctamente.");
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody OfertasProductoDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        OfertasProducto op = m.map(dto, OfertasProducto.class);
        OfertasProducto existente = service.listId(op.getIdOfertasProducto());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe oferta con ID: " + op.getIdOfertasProducto());
        }
        service.edit(op);
        return ResponseEntity.ok("Oferta con ID " + op.getIdOfertasProducto() + " modificada correctamente.");
    }

    @GetMapping("/buscar-fecha")
    public List<OfertasProductoDTOList> buscarPorProductoYFecha(@RequestParam int idProducto,
                                                                @RequestParam String fecha) {
        LocalDate fechaConsulta = LocalDate.parse(fecha);
        return service.buscarPorProductoYFecha(idProducto, fechaConsulta)
                .stream().map(o -> new ModelMapper().map(o, OfertasProductoDTOList.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar-rango")
    public List<OfertasProductoDTOList> buscarPorProductoYRangoFechas(@RequestParam int idProducto,
                                                                      @RequestParam String fechaInicio,
                                                                      @RequestParam String fechaFin) {
        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        return service.buscarPorProductoYRangoFechas(idProducto, inicio, fin)
                .stream().map(o -> new ModelMapper().map(o, OfertasProductoDTOList.class))
                .collect(Collectors.toList());
    }
}
