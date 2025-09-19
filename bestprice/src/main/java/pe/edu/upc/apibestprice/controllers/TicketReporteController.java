package pe.edu.upc.apibestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apibestprice.dtos.RolDTO;
import pe.edu.upc.apibestprice.dtos.TicketReporteDTO;
import pe.edu.upc.apibestprice.entities.TicketReporte;
import pe.edu.upc.apibestprice.serviceinterfaces.ITicketReporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticketreporte")
public class TicketReporteController {

    @Autowired
    private ITicketReporteService reporteService;

    @GetMapping("/listar")
    public List<RolDTO> listar(){
        return reporteService.listarTicketReporte().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody TicketReporteDTO dto) {
        ModelMapper m = new ModelMapper();
        TicketReporte soft = m.map(dto,TicketReporte.class);
        reporteService.insertarTicketReporte(soft);
    }
}
