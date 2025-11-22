package pe.edu.upc.bestprice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.dtos.TipoResenaDTOInsert;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiporesena")
public class TipoResenaController {

    @Autowired
    private ITipoResenaService tipoResenaService;

    // ---------------------------
    // GET: todos los tipos
    // ---------------------------
    @GetMapping
    public List<TipoResenaDTO> getAllTipoResena() {
        List<TipoResena> tipoResenaList = tipoResenaService.getAllTipoResena();
        return tipoResenaList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // ---------------------------
    // GET: por ID
    // ---------------------------
    @GetMapping("/{id}")
    public ResponseEntity<TipoResenaDTO> getTipoResenaById(@PathVariable int id) {
        TipoResena tipoResena = tipoResenaService.getTipoResenaById(id);
        if (tipoResena != null) {
            return ResponseEntity.ok(convertToDTO(tipoResena));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ---------------------------
    // POST: crear (usa DTOInsert)
    // ---------------------------
    @PostMapping
    public ResponseEntity<TipoResenaDTOInsert> createTipoResena(
            @RequestBody TipoResenaDTOInsert tipoResenaDTOInsert) {

        // Usa la sobrecarga convertToEntity(TipoResenaDTOInsert)
        TipoResena tipoResena = convertToEntity(tipoResenaDTOInsert);
        TipoResena createdTipoResena = tipoResenaService.createTipoResena(tipoResena);

        // Devuelve TipoResenaDTOInsert (solo el campo tiporeseTipoResena)
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(convertToDTOInsert(createdTipoResena));
    }

    // ---------------------------
    // PUT: actualizar (usa DTOInsert)
    // ---------------------------
    @PutMapping("/{id}")
    public ResponseEntity<TipoResenaDTOInsert> updateTipoResena(
            @PathVariable int id,
            @RequestBody TipoResenaDTOInsert tipoResenaDTOInsert) {

        TipoResena existingTipoResena = tipoResenaService.getTipoResenaById(id);

        if (existingTipoResena != null) {
            // Usa la sobrecarga convertToEntity(TipoResenaDTOInsert)
            TipoResena updatedTipoResena = convertToEntity(tipoResenaDTOInsert);

            // Asigna el ID existente
            updatedTipoResena.setIdTipoResena(id);

            // Si TipoResena tiene otros campos además de tiporeseTipoResena,
            // aquí podrías copiarlos desde existingTipoResena.

            tipoResenaService.updateTipoResena(updatedTipoResena);

            // Devuelve TipoResenaDTOInsert (solo la descripción)
            return ResponseEntity.ok(convertToDTOInsert(updatedTipoResena));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // ---------------------------
    // DELETE: eliminar por ID
    // ---------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoResena(@PathVariable int id) {
        tipoResenaService.deleteTipoResena(id);
        return ResponseEntity.noContent().build();
    }

    // ===========================
    // MÉTODOS DE CONVERSIÓN
    // ===========================

    // Entidad -> TipoResenaDTO (para GET)
    private TipoResenaDTO convertToDTO(TipoResena tipoResena) {
        return new TipoResenaDTO(
                tipoResena.getIdTipoResena(),
                tipoResena.getTiporeseTipoResena()
        );
    }

    // Entidad -> TipoResenaDTOInsert (para respuestas de POST/PUT)
    private TipoResenaDTOInsert convertToDTOInsert(TipoResena tipoResena) {
        return new TipoResenaDTOInsert(
                tipoResena.getTiporeseTipoResena()
        );
    }

    // TipoResenaDTO -> Entidad (no lo usas ahora, pero lo dejo por si acaso)
    private TipoResena convertToEntity(TipoResenaDTO tipoResenaDTO) {
        return new TipoResena(
                tipoResenaDTO.getIdTipoResena(),
                tipoResenaDTO.getTiporeseTipoResena()
        );
    }

    // TipoResenaDTOInsert -> Entidad (para POST y PUT)
    private TipoResena convertToEntity(TipoResenaDTOInsert tipoResenaDTOInsert) {
        return new TipoResena(
                0, // el ID lo asigna la BD o se setea en el PUT
                tipoResenaDTOInsert.getTiporeseTipoResena()
        );
    }
}
