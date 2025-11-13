package pe.edu.upc.bestprice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoResenaDTO;
import pe.edu.upc.bestprice.entities.TipoResena;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoResenaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiporesena")
public class TipoResenaController {

    @Autowired
    private ITipoResenaService tipoResenaService;

    // Obtener todos los tipos de reseña
    @GetMapping
    public List<TipoResenaDTO> getAllTipoResena() {
        List<TipoResena> tipoResenaList = tipoResenaService.getAllTipoResena();
        return tipoResenaList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener un tipo de reseña por ID
    @GetMapping("/{id}")
    public ResponseEntity<TipoResenaDTO> getTipoResenaById(@PathVariable int id) {
        TipoResena tipoResena = tipoResenaService.getTipoResenaById(id);
        if (tipoResena != null) {
            return ResponseEntity.ok(convertToDTO(tipoResena));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo tipo de reseña
    @PostMapping
    public ResponseEntity<TipoResenaDTO> createTipoResena(@RequestBody TipoResenaDTO tipoResenaDTO) {
        TipoResena tipoResena = convertToEntity(tipoResenaDTO);
        TipoResena createdTipoResena = tipoResenaService.createTipoResena(tipoResena);
        return ResponseEntity.status(201).body(convertToDTO(createdTipoResena));
    }

    // Actualizar un tipo de reseña
    @PutMapping("/{id}")
    public ResponseEntity<TipoResenaDTO> updateTipoResena(@PathVariable int id, @RequestBody TipoResenaDTO tipoResenaDTO) {
        TipoResena existingTipoResena = tipoResenaService.getTipoResenaById(id);
        if (existingTipoResena != null) {
            TipoResena updatedTipoResena = convertToEntity(tipoResenaDTO);
            updatedTipoResena.setIdTipoResena(id);
            tipoResenaService.updateTipoResena(updatedTipoResena);
            return ResponseEntity.ok(convertToDTO(updatedTipoResena));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un tipo de reseña
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoResena(@PathVariable int id) {
        tipoResenaService.deleteTipoResena(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir entidad a DTO
    private TipoResenaDTO convertToDTO(TipoResena tipoResena) {
        return new TipoResenaDTO(
                tipoResena.getIdTipoResena(),
                tipoResena.getTiporeseTipoResena()
        );
    }

    // Convertir DTO a entidad
    private TipoResena convertToEntity(TipoResenaDTO tipoResenaDTO) {
        return new TipoResena(
                tipoResenaDTO.getIdTipoResena(),
                tipoResenaDTO.getTiporeseTipoResena()
        );
    }
}
