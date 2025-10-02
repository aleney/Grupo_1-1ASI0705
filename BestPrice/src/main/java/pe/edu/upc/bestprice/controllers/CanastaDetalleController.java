package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.CanastaDetalleDTO;
import pe.edu.upc.bestprice.entities.CanastaDetalle;
import pe.edu.upc.bestprice.repositories.ICanastaDetalleRepository;
import pe.edu.upc.bestprice.serviceimplements.CanastaDetalleServiceImplement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/Canasta_Detalle")
public class CanastaDetalleController{

    @Autowired
    private CanastaDetalleServiceImplement service;

    @GetMapping
    public List<CanastaDetalleDTO> listar() {
        return service.list().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, CanastaDetalleDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CanastaDetalleDTO dto) {
        ModelMapper m = new ModelMapper();
        CanastaDetalle detalle = m.map(dto, CanastaDetalle.class);
        service.insert(detalle);
    }

    @GetMapping("/id")
    public ResponseEntity<?> listarId(@PathVariable String id) {
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
