package pe.edu.upc.apibestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apibestprice.dtos.RolDTO;
import pe.edu.upc.apibestprice.dtos.TicketRespuestaDTO;
import pe.edu.upc.apibestprice.entities.TicketRespuesta;
import pe.edu.upc.apibestprice.serviceinterfaces.ITicketRespuestaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketrespuesta")
public class TicketRespuestaController {

    @Autowired
    private ITicketRespuestaService reporteService;

    @GetMapping("/listar")
    public List<RolDTO> listar(){
        return reporteService.listarTicketRespuesta().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody TicketRespuestaDTO dto) {
        ModelMapper m = new ModelMapper();
        TicketRespuesta soft = m.map(dto,TicketRespuesta.class);
        reporteService.insertarTicketRespuesta(soft);
    }
}
