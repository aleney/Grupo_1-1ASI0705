package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.bestprice.dtos.HistorialBusquedaDTO;
import pe.edu.upc.bestprice.entities.HistorialBusqueda;
import pe.edu.upc.bestprice.serviceinterfaces.IHistorialBusquedaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Historial_Busqueda")
public class HistorialBusquedaController {

    @Autowired
    private IHistorialBusquedaService service;

    @GetMapping("/listas")
    public List<HistorialBusquedaDTO> listar(){
        return service.list().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,HistorialBusquedaDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/nuevos")
    public void insertar(@RequestBody HistorialBusquedaDTO dto){
        ModelMapper m=new ModelMapper();
        HistorialBusqueda historial=m.map(dto,HistorialBusqueda.class);
        service.insert(historial);
    }
}
