package pe.edu.pe.bestprice.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bestprice.dtos.TipoTiendaDTO;
import pe.edu.pe.bestprice.entities.TipoTienda;
import pe.edu.pe.bestprice.servicesinterfaces.ITipoTiendaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tipoTiendas")
public class TipoTiendaController {

    @Autowired
    private ITipoTiendaService Tts;

    @GetMapping("listartiendas")
    public List<TipoTiendaDTO> ListarTipoTienda() {
        return Tts.listarTipoTiendas().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TipoTiendaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrarTipoTienda")
    public void RegistrarTipoTienda(@RequestBody TipoTiendaDTO ttdto) {
        ModelMapper m=new ModelMapper();
        TipoTienda tt=m.map(ttdto,TipoTienda.class);
        Tts.insert(tt);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTipoTienda(@PathVariable("id") Integer id) {
        TipoTienda ttdtos = Tts.listarIdTipoTienda(id);
        if (ttdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de Tipo tiendas" + id);
        }
        ModelMapper m = new ModelMapper();
        TipoTiendaDTO ttdt = m.map(ttdtos, TipoTiendaDTO.class);
        return ResponseEntity.ok(ttdt);
    }

}
