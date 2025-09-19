package pe.edu.pe.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bestprice.dtos.ResenaDTOInsert;
import pe.edu.pe.bestprice.dtos.ResenaDTOList;
import pe.edu.pe.bestprice.dtos.ResenaDTOListCalAsc;
import pe.edu.pe.bestprice.entities.Resena;
import pe.edu.pe.bestprice.entities.TipoResena;
import pe.edu.pe.bestprice.servicesinterfaces.IResenaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Resenas")
public class ResenaController {

    @Autowired
    private IResenaService service;

    @GetMapping("/listar")
    public List<ResenaDTOList> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, ResenaDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody ResenaDTOInsert dto){
        ModelMapper m = new ModelMapper();
        Resena r = m.map(dto, Resena.class);
        service.insert(r);
    }

    @PutMapping("/modificar")
    public ResponseEntity<String> modificar(@RequestBody ResenaDTOInsert dto) {
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

    @GetMapping("/calificacion")
    public ResponseEntity<?> CalificacionTipo() {
        List<String[]> calificacion = service.ListarCalificacionPorResena();
        List<ResenaDTOListCalAsc> ListaCalificacion = new ArrayList<>();

        if (calificacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reseñas");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : calificacion) {
            ResenaDTOListCalAsc dto = new ResenaDTOListCalAsc();
            dto.setCalificacionResena(Integer.parseInt(columna[0]));

            TipoResena tipo = new TipoResena();
            tipo.setIdTipoResena(Integer.parseInt(columna[1]));
            dto.setTipoResena(tipo);

            ListaCalificacion.add(dto);
        }
        return ResponseEntity.ok(ListaCalificacion);
    }

}
