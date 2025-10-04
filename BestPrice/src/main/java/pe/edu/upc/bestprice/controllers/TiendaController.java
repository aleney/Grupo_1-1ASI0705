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
@RequestMapping("/Tienda")
public class TiendaController {

    @Autowired
    private ITiendaService Ts;

    @GetMapping("listarTienda")
    public List<TiendaDTO> listarTienda() {
        return Ts.listarTienda().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrarTienda")
    public void RegistrarTienda(@RequestBody TiendaDTO tdtos) {
        ModelMapper m=new ModelMapper();
        Tienda t=m.map(tdtos,Tienda.class);
        Ts.insert(t);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTienda(@PathVariable("id") Integer id) {
        Tienda tdtos = Ts.listarIdTienda(id);
        if (tdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de Tienda" + id);
        }
        ModelMapper m = new ModelMapper();
        TiendaDTO tdt = m.map(tdtos, TiendaDTO.class);
        return ResponseEntity.ok(tdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tienda td = Ts.listarIdTienda(id);
        if (td == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        Ts.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        Tienda t = m.map(dto, Tienda.class);
        Tienda existente = Ts.listarIdTienda(t.getIdTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + t.getIdTienda());
        }

        // Actualización si pasa validaciones
        Ts.update(t);
        return ResponseEntity.ok("Registro con ID " + t.getIdTienda() + " modificado correctamente.");
    }

}
