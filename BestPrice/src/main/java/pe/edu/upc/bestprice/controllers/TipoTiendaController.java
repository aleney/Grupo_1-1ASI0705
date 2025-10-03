package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoTiendaDTO;
import pe.edu.upc.bestprice.entities.TipoTienda;
import pe.edu.upc.bestprice.servicesinterfaces.ITipoTiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoTiendas")
public class TipoTiendaController {

    @Autowired
    private ITipoTiendaService Tts;

    @GetMapping("listartiendas")
    public List<TipoTiendaDTO> ListarTipoTienda() {
        return Tts.listarTipoTiendas().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TipoTiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrarTipoTienda")
    public void RegistrarTipoTienda(@RequestBody TipoTiendaDTO ttdto) {
        ModelMapper m=new ModelMapper();
        TipoTienda tt=m.map(ttdto,TipoTienda.class);
        Tts.insert(tt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTipoTienda(@PathVariable("id") Integer id) {
        TipoTienda ttdtos = Tts.listarIdTipoTienda(id);
        if (ttdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de Tipo tiendas" + id);
        }
        ModelMapper m = new ModelMapper();
        TipoTiendaDTO ttdt = m.map(ttdtos, TipoTiendaDTO.class);
        return ResponseEntity.ok(ttdt);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        TipoTienda tt = Tts.listarIdTipoTienda(id);
        if (tt == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        Tts.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody TipoTiendaDTO dto) {
        ModelMapper m = new ModelMapper();
        TipoTienda tt = m.map(dto, TipoTienda.class);
        TipoTienda existente = Tts.listarIdTipoTienda(tt.getIdTipoTienda());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + tt.getIdTipoTienda());
        }

        // Actualización si pasa validaciones
        Tts.update(tt);
        return ResponseEntity.ok("Registro con ID " + tt.getIdTipoTienda() + " modificado correctamente.");
    }

}