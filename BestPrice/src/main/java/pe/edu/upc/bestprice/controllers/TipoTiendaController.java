package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoTiendaDTO;
import pe.edu.upc.bestprice.entities.TipoTienda;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoTiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo-tienda")
public class TipoTiendaController {

    @Autowired
    private ITipoTiendaService service;

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
        List<TipoTiendaDTO> lista = service.listarTipoTienda().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, TipoTiendaDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tipos de tienda registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    public ResponseEntity<String> insertar(@RequestBody TipoTiendaDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            TipoTienda tt = m.map(dto, TipoTienda.class);
            service.insert(tt);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Tipo de tienda registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el tipo de tienda. Verifica que los datos enviados sean correctos.");
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTipoTienda(@PathVariable("id") Integer id) {
        TipoTienda ttdtos = service.listarIdTipoTienda(id);
        if (ttdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de Tipo Tienda" + id);
        }
        ModelMapper m = new ModelMapper();
        TipoTiendaDTO ttdt = m.map(ttdtos, TipoTiendaDTO.class);
        return ResponseEntity.ok(ttdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoTienda tt = service.listarIdTipoTienda(id);
        if (tt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipoTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTienda tt = m.map(dto, TipoTienda.class);
        TipoTienda existente = service.listarIdTipoTienda(tt.getIdTipoTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tt.getIdTipoTienda());
        }

        // Actualización si pasa validaciones
        service.update(tt);
        return ResponseEntity.ok("Registro con ID " + tt.getIdTipoTienda() + " modificado correctamente.");
    }

}