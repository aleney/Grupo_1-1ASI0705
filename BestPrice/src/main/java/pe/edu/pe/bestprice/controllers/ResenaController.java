package pe.edu.pe.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bestprice.dtos.ResenaDTO;
import pe.edu.pe.bestprice.entities.Resena;
import pe.edu.pe.bestprice.servicesinterfaces.IResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Resenas")
public class ResenaController {

    @Autowired
    private IResenaService service;

    @GetMapping("/listar")
    public List<ResenaDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,ResenaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody ResenaDTO dto){
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        service.insert(r);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody ResenaDTO dto) {
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);

        // Validación de existencia
        Resena existente = service.ListId(r.getIdResena());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + r.getIdResena());
        }

        // Actualización si pasa validaciones
        service.update(r);
        return ResponseEntity.ok("Registro con ID " + r.getIdResena() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Resena r = service.ListId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }


}
