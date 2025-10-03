package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TiendasDTO;
import pe.edu.upc.bestprice.entities.Tiendas;
import pe.edu.upc.bestprice.servicesinterfaces.ITiendasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendasController {

    @Autowired
    private ITiendasService Ts;

    @GetMapping("listartiendas")
    public List<TiendasDTO> listarTienda() {
        return Ts.listarTiendas().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TiendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrarTienda")
    public void RegistrarTienda(@RequestBody TiendasDTO tdtos) {
        ModelMapper m=new ModelMapper();
        Tiendas t=m.map(tdtos,Tiendas.class);
        Ts.insert(t);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTienda(@PathVariable("id") Integer id) {
        Tiendas tdtos = Ts.listarIdTiendas(id);
        if (tdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de tiendas" + id);
        }
        ModelMapper m = new ModelMapper();
        TiendasDTO tdt = m.map(tdtos, TiendasDTO.class);
        return ResponseEntity.ok(tdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Tiendas td = Ts.listarIdTiendas(id);
        if (td == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        Ts.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TiendasDTO dto) {
        ModelMapper m = new ModelMapper();
        Tiendas t = m.map(dto, Tiendas.class);
        Tiendas existente = Ts.listarIdTiendas(t.getIdTiendas());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + t.getIdTiendas());
        }

        // Actualización si pasa validaciones
        Ts.update(t);
        return ResponseEntity.ok("Registro con ID " + t.getIdTiendas() + " modificado correctamente.");
    }

}
