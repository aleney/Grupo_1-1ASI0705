package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.LineaTiendaDTO;
import pe.edu.upc.bestprice.dtos.LineaTiendaDTOTiendaAnio;
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
    public List<LineaTiendaDTO>listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody LineaTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        LineaTienda lt = m.map(dto, LineaTienda.class);
        service.insert(lt);
    }

    @GetMapping("/{id}")
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
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<LineaTienda> lt = service.buscarService(n);

        if (lt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron Tienda de nombre o caracter: " + n);
        }

        List<LineaTiendaDTO> listaDTO = lt.stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendaDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/Tienda2025")
    public ResponseEntity<?> TiendaAnioactual() {
        List<String[]> Tienda = service.TiendaCreadasEn2025();
        List<LineaTiendaDTOTiendaAnio> ListaTienda = new ArrayList<>();

        if (Tienda.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores registrados");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : Tienda) {
            LineaTiendaDTOTiendaAnio dto = new LineaTiendaDTOTiendaAnio();
            dto.setCreatedAt(LocalDate.parse(columna[1]));
            dto.setNombreLineaTienda((columna[0]));
            ListaTienda.add(dto);
        }
        return ResponseEntity.ok(ListaTienda);
    }
}
