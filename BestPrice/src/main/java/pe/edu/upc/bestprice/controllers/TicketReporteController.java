package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.RolDTO;
import pe.edu.upc.bestprice.dtos.TicketReporteDTO;
import pe.edu.upc.bestprice.entities.TicketReporte;
import pe.edu.upc.bestprice.serviceinterfaces.ITicketReporteService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ticket-reporte")
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
