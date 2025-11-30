package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.CanastaDetalleDTO;
import pe.edu.upc.bestprice.dtos.CanastaDetalleDTOInsert;
import pe.edu.upc.bestprice.entities.CanastaDetalle;
import pe.edu.upc.bestprice.repositories.ICanastaDetalleRepository;
import pe.edu.upc.bestprice.serviceimplements.CanastaDetalleServiceImplement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/canasta-detalle")
public class CanastaDetalleController{

    @Autowired
    private CanastaDetalleServiceImplement service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<?> listar() {
        List<CanastaDetalleDTO> lista = service.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, CanastaDetalleDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron detalles de canasta registrados.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'CLIENT','SELLER')")
    public ResponseEntity<String> insertar(@RequestBody CanastaDetalleDTOInsert dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            CanastaDetalle detalle = m.map(dto, CanastaDetalle.class);
            service.insert(detalle);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Detalle de canasta registrado correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar el detalle de canasta. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/id")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listarId(@PathVariable Integer id) {
        CanastaDetalle detalle = service.listId(id);
        if (detalle == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        CanastaDetalleDTO dto = m.map(detalle, CanastaDetalleDTO.class);
        return ResponseEntity.ok(dto);

    }
}
