package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.OfertasProductoDTO;
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
    @PreAuthorize("hasAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> listar() {
        List<OfertasProductoDTO> lista = service.list().stream().map(o -> {
            ModelMapper m = new ModelMapper();
            return m.map(o, OfertasProductoDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron ofertas de productos registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<String> insertar(@RequestBody OfertasProductoDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            OfertasProducto op = m.map(dto, OfertasProducto.class);
            service.insert(op);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Oferta de producto registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la oferta de producto. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        OfertasProducto op = service.listId(id);
        if (op == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe oferta con ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        OfertasProductoDTO dto = m.map(op, OfertasProductoDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody OfertasProductoDTO dto) {
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<OfertasProductoDTO> buscarPorProductoYFecha(@RequestParam int idProducto,
                                                            @RequestParam String fecha) {
        LocalDate fechaConsulta = LocalDate.parse(fecha);
        return service.buscarPorProductoYFecha(idProducto, fechaConsulta)
                .stream().map(o -> new ModelMapper().map(o, OfertasProductoDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buscar-rango")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<OfertasProductoDTO> buscarPorProductoYRangoFechas(@RequestParam int idProducto,
                                                                  @RequestParam String fechaInicio,
                                                                  @RequestParam String fechaFin) {
        LocalDate inicio = LocalDate.parse(fechaInicio);
        LocalDate fin = LocalDate.parse(fechaFin);
        return service.buscarPorProductoYRangoFechas(idProducto, inicio, fin)
                .stream().map(o -> new ModelMapper().map(o, OfertasProductoDTO.class))
                .collect(Collectors.toList());
    }
}
