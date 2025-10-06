package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.LineaTiendaDTO;
import pe.edu.upc.bestprice.dtos.LineaTiendaDTOTiendasAnio;
import pe.edu.upc.bestprice.entities.LineaTienda;
import pe.edu.upc.bestprice.serviceinterfaces.ILineaTiendaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/linea-tienda")
public class LineaTiendaController {

    @Autowired
    private ILineaTiendaService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> listar() {
        List<LineaTiendaDTO> lista = service.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron líneas de tienda registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> insertar(@RequestBody LineaTiendaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            LineaTienda lt = m.map(dto, LineaTienda.class);
            service.insert(lt);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Línea de tienda registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la línea de tienda. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/listar/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        LineaTienda lt = service.ListId(id);
        if (lt == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        LineaTiendaDTO dto = m.map(lt, LineaTiendaDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        LineaTienda lt = service.ListId(id);
        if (lt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> modificar(@RequestBody LineaTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        LineaTienda lt = m.map(dto, LineaTienda.class);

        // Validación de existencia
        LineaTienda existente = service.ListId(lt.getIdLineaTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + lt.getIdLineaTienda());
        }

        // Actualización si pasa validaciones
        service.update(lt);
        return ResponseEntity.ok("Registro con ID " + lt.getIdLineaTienda() + " modificado correctamente.");
    }

    @GetMapping("/buscarnombre")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<LineaTienda> lt = service.buscarService(n);

        if (lt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tiendas de nombre o caracter: " + n);
        }

        List<LineaTiendaDTO> listaDTO = lt.stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendaDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/tiendas2025")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'SELLER', 'CLIENT')")
    public ResponseEntity<?> TiendasAnioactual() {
        List<String[]> tiendas = service.TiendasCreadasEn2025();
        List<LineaTiendaDTOTiendasAnio> ListaTiendas = new ArrayList<>();

        if (tiendas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores registrados");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : tiendas) {
            LineaTiendaDTOTiendasAnio dto = new LineaTiendaDTOTiendasAnio();
            dto.setCreatedAt(LocalDate.parse(columna[1]));
            dto.setNombreLineaTienda((columna[0]));
            ListaTiendas.add(dto);
        }
        return ResponseEntity.ok(ListaTiendas);
    }
}
