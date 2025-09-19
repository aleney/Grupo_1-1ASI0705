package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.TipoReseñaDTO;
import pe.edu.upc.bestprice.entities.TipoReseña;
import pe.edu.upc.bestprice.serviceinterfaces.ITipoReseñaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipo_reseña")
public class TipoReseñaController {

    @Autowired
    private ITipoReseñaService service;

    @GetMapping("/listas")
    public List<TipoReseñaDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TipoReseñaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/nuevos")
    public void insertar(@RequestBody TipoReseñaDTO dto){
        ModelMapper m=new ModelMapper();
        TipoReseña tipo=m.map(dto,TipoReseña.class);
        service.insert(tipo);
    }
}
