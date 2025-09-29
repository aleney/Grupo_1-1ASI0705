package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.LineaTiendasDTO;
import pe.edu.upc.bestprice.dtos.LineaTiendasDTOTiendasAnho;
import pe.edu.upc.bestprice.entities.LineaTiendas;
import pe.edu.upc.bestprice.serviceinterfaces.ILineaTiendasService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/LineaTiendas")
public class LineaTiendasController {

    @Autowired
    private ILineaTiendasService service;

    @GetMapping("/listar")
    public List<LineaTiendasDTO>listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody LineaTiendasDTO dto) {
        ModelMapper m = new ModelMapper();
        LineaTiendas lt = m.map(dto, LineaTiendas.class);
        service.insert(lt);
    }

    @GetMapping("/eliminar/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        LineaTiendas lt = service.ListId(id);
        if (lt == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        LineaTiendasDTO dto = m.map(lt, LineaTiendasDTO.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        LineaTiendas lt = service.ListId(id);
        if (lt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody LineaTiendasDTO dto) {
        ModelMapper m = new ModelMapper();
        LineaTiendas lt = m.map(dto, LineaTiendas.class);

        // Validación de existencia
        LineaTiendas existente = service.ListId(lt.getIdLineaTiendas());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + lt.getIdLineaTiendas());
        }

        // Actualización si pasa validaciones
        service.update(lt);
        return ResponseEntity.ok("Registro con ID " + lt.getIdLineaTiendas() + " modificado correctamente.");
    }

    @GetMapping("/buscarnombre")
    public ResponseEntity<?> buscar(@RequestParam String n) {
        List<LineaTiendas> lt = service.buscarService(n);

        if (lt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tiendas de nombre o caracter: " + n);
        }

        List<LineaTiendasDTO> listaDTO = lt.stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendasDTO.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/tiendas2025")
    public ResponseEntity<?> TiendasAnhoactual() {
        List<String[]> tiendas = service.TiendasCreadasEn2025();
        List<LineaTiendasDTOTiendasAnho> ListaTiendas = new ArrayList<>();

        if (tiendas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron proveedores registrados");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : tiendas) {
            LineaTiendasDTOTiendasAnho dto = new LineaTiendasDTOTiendasAnho();
            dto.setCreatedAt(LocalDate.parse(columna[1]));
            dto.setNombreLineaTiendas((columna[0]));
            ListaTiendas.add(dto);
        }
        return ResponseEntity.ok(ListaTiendas);
    }
}
