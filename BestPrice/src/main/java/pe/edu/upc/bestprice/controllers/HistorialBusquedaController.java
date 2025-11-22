package pe.edu.upc.bestprice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.HistorialBusquedaDTO;
import pe.edu.upc.bestprice.dtos.HistorialBusquedaDTOInsert; // Importa el DTO de Inserción
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

    /**
     * ✅ CREAR un nuevo registro de historial de búsqueda (Usa HistorialBusquedaDTOInsert)
     * Request Body: HistorialBusquedaDTOInsert
     * Response Body: HistorialBusquedaDTO (El DTO completo después de la creación)
     */
    @PostMapping
    public ResponseEntity<HistorialBusquedaDTO> createHistorialBusqueda(@RequestBody HistorialBusquedaDTOInsert historialBusquedaDTOInsert) {
        // Usa la sobrecarga del método para convertir el DTO de inserción
        HistorialBusqueda historial = convertToEntity(historialBusquedaDTOInsert);
        HistorialBusqueda createdHistorial = historialBusquedaService.createHistorialBusqueda(historial);

        // Se devuelve el DTO completo con el ID generado y la fecha generada por la DB
        return ResponseEntity.status(201).body(convertToDTO(createdHistorial));
    }

    /**
     * ✅ ACTUALIZAR un registro de historial de búsqueda (Usa HistorialBusquedaDTOInsert)
     */
    @PutMapping("/{id}")
    public ResponseEntity<HistorialBusquedaDTO> updateHistorialBusqueda(@PathVariable int id, @RequestBody HistorialBusquedaDTOInsert historialBusquedaDTOInsert) {
        HistorialBusqueda existingHistorial = historialBusquedaService.getHistorialBusquedaById(id);

        if (existingHistorial != null) {
            // Convertir el DTO de actualización a entidad, manteniendo la fecha original (si no se actualiza)
            HistorialBusqueda updatedHistorial = convertToEntity(historialBusquedaDTOInsert);

            // Reestablecer el ID (necesario para la actualización) y la fecha original
            updatedHistorial.setIdHistorialBusqueda(id);
            updatedHistorial.setFechabusqueHistorialBusqueda(existingHistorial.getFechabusqueHistorialBusqueda());

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

    // --- Métodos de Conversión ---

    // Convertir entidad a DTO (Para lectura/respuesta)
    private HistorialBusquedaDTO convertToDTO(HistorialBusqueda historial) {
        return new HistorialBusquedaDTO(
                historial.getIdHistorialBusqueda(),
                historial.getFechabusqueHistorialBusqueda(),
                historial.getProductoidHistoriaBusqueda(),
                historial.getUsuarioidHistoriaBusqueda()
        );
    }

    // Convertir DTO a entidad (Para actualizar/lectura - Mantiene ID/Fecha para update)
    private HistorialBusqueda convertToEntity(HistorialBusquedaDTO historialBusquedaDTO) {
        HistorialBusqueda entity = new HistorialBusqueda();
        entity.setIdHistorialBusqueda(historialBusquedaDTO.getIdHistorialBusqueda());
        entity.setFechabusqueHistorialBusqueda(historialBusquedaDTO.getFechabusqueHistorialBusqueda());
        entity.setProductoidHistoriaBusqueda(historialBusquedaDTO.getProductoidHistoriaBusqueda());
        entity.setUsuarioidHistoriaBusqueda(historialBusquedaDTO.getUsuarioidHistoriaBusqueda());
        return entity;
    }

    // Convertir DTOInsert a entidad (Para crear - No tiene ID ni Fecha)
    private HistorialBusqueda convertToEntity(HistorialBusquedaDTOInsert historialBusquedaDTOInsert) {
        // En una inserción, el ID y la fecha se generan automáticamente,
        // solo pasamos los IDs de las claves foráneas.
        HistorialBusqueda entity = new HistorialBusqueda();
        entity.setProductoidHistoriaBusqueda(historialBusquedaDTOInsert.getProductoidHistoriaBusqueda());
        entity.setUsuarioidHistoriaBusqueda(historialBusquedaDTOInsert.getUsuarioidHistoriaBusqueda());
        return entity;
    }
}