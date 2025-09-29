package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
    private ICanastaDetalleRepository canastaDetalleRepository;
    private CanastaDetalleServiceImplement service;

    @GetMapping
    public List<CanastaDetalle> getAllDetalles(){
        return canastaDetalleRepository.findAll();
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
