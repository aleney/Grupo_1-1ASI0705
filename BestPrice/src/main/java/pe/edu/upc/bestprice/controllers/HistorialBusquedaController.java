package pe.edu.upc.bestprice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.HistorialBusquedaDTO;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/historialbusqueda")
public class HistorialBusquedaController {

    @Autowired
    private IHistorialBusquedaService historialBusquedaService;

    // Obtener todos los registros de historial de búsqueda
    @GetMapping
    public List<HistorialBusquedaDTO> getAllHistorialBusqueda() {
        List<HistorialBusqueda> historialList = historialBusquedaService.getAllHistorialBusqueda();
        return historialList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener un registro de historial de búsqueda por ID
    @GetMapping("/{id}")
    public ResponseEntity<HistorialBusquedaDTO> getHistorialBusquedaById(@PathVariable int id) {
        HistorialBusqueda historial = historialBusquedaService.getHistorialBusquedaById(id);
        if (historial != null) {
            return ResponseEntity.ok(convertToDTO(historial));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un nuevo registro de historial de búsqueda
    @PostMapping
    public ResponseEntity<HistorialBusquedaDTO> createHistorialBusqueda(@RequestBody HistorialBusquedaDTO historialBusquedaDTO) {
        HistorialBusqueda historial = convertToEntity(historialBusquedaDTO);
        HistorialBusqueda createdHistorial = historialBusquedaService.createHistorialBusqueda(historial);
        return ResponseEntity.status(201).body(convertToDTO(createdHistorial));
    }

    // Actualizar un registro de historial de búsqueda
    @PutMapping("/{id}")
    public ResponseEntity<HistorialBusquedaDTO> updateHistorialBusqueda(@PathVariable int id, @RequestBody HistorialBusquedaDTO historialBusquedaDTO) {
        HistorialBusqueda existingHistorial = historialBusquedaService.getHistorialBusquedaById(id);
        if (existingHistorial != null) {
            HistorialBusqueda updatedHistorial = convertToEntity(historialBusquedaDTO);
            updatedHistorial.setIdHistorialBusqueda(id);
            historialBusquedaService.updateHistorialBusqueda(updatedHistorial);
            return ResponseEntity.ok(convertToDTO(updatedHistorial));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un registro de historial de búsqueda
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorialBusqueda(@PathVariable int id) {
        historialBusquedaService.deleteHistorialBusqueda(id);
        return ResponseEntity.noContent().build();
    }

    // Convertir entidad a DTO
    private HistorialBusquedaDTO convertToDTO(HistorialBusqueda historial) {
        return new HistorialBusquedaDTO(
                historial.getIdHistorialBusqueda(),
                historial.getFechabusqueHistorialBusqueda(),
                historial.getProductoidHistoriaBusqueda(),
                historial.getUsuarioidHistoriaBusqueda()
        );
    }

    // Convertir DTO a entidad
    private HistorialBusqueda convertToEntity(HistorialBusquedaDTO historialBusquedaDTO) {
        return new HistorialBusqueda(
                historialBusquedaDTO.getIdHistorialBusqueda(),
                historialBusquedaDTO.getFechabusqueHistorialBusqueda(),
                historialBusquedaDTO.getProductoidHistoriaBusqueda(),
                historialBusquedaDTO.getUsuarioidHistoriaBusqueda()
        );
    }
}
