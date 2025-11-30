package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.ResenaDTOInsert;
import pe.edu.upc.bestprice.dtos.ResenaDTOList;
import pe.edu.upc.bestprice.dtos.ResenaDTOListCalAsc;
import pe.edu.upc.bestprice.dtos.ResenaDTOListTiendaCal;
import pe.edu.upc.bestprice.entities.Resena;
import pe.edu.upc.bestprice.serviceinterfaces.IResenaService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resena")
public class ResenaController {

    @Autowired
    private IResenaService service;


    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> listar() {
        List<ResenaDTOList> lista = service.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, ResenaDTOList.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reseñas registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
    public ResponseEntity<String> insertar(@RequestBody ResenaDTOInsert dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            Resena r = m.map(dto, Resena.class);
            service.insert(r);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Reseña registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la reseña. Verifica que los datos enviados sean correctos.");
        }
    }

    @PutMapping("/modificar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> CalificacionTipo() {
        List<String[]> calificacion = service.ListarCalificacionPorTipoResena();
        List<ResenaDTOListCalAsc> ListaCalificacion = new ArrayList<>();

        if (calificacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron Resenas");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : calificacion) {
            ResenaDTOListCalAsc dto = new ResenaDTOListCalAsc();
            dto.setCalificacionResena(Integer.parseInt(columna[0]));
            dto.setTiporeseTipoResena(columna[1]);

            ListaCalificacion.add(dto);
        }
        return ResponseEntity.ok(ListaCalificacion);
    }

    @GetMapping("/tienda-calificada")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT', 'SELLER')")
    public ResponseEntity<?> CalificacionMejores5Tiendas() {
        List<String[]> tiendacalificada = service.ListarTiendaporCalificacion();
        List<ResenaDTOListTiendaCal> ListaCalificacion = new ArrayList<>();

        if (tiendacalificada.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron reseñas");
        }

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : tiendacalificada) {
            ResenaDTOListTiendaCal dto = new ResenaDTOListTiendaCal();
            dto.setCalificacionResena(Integer.parseInt(columna[0]));
            dto.setNombreTienda(columna[1]);

            ListaCalificacion.add(dto);
        }
        return ResponseEntity.ok(ListaCalificacion);
    }

}
