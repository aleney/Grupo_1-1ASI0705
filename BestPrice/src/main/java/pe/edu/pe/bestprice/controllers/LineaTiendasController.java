package pe.edu.pe.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bestprice.dtos.LineaTiendasDTO;
import pe.edu.pe.bestprice.entities.LineaTiendas;
import pe.edu.pe.bestprice.servicesinterfaces.ILineaTiendasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/LineaTiendas")
public class LineaTiendasController {

    @Autowired
    private ILineaTiendasService service;

    @GetMapping
    public List<LineaTiendasDTO>listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a, LineaTiendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody LineaTiendasDTO dto) {
        ModelMapper m = new ModelMapper();
        LineaTiendas lt = m.map(dto, LineaTiendas.class);
        service.insert(lt);
    }
}
