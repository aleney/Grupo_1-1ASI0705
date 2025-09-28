package pe.edu.upc.BestPrice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.BestPrice.dtos.TiendasDTO;
import pe.edu.upc.BestPrice.entities.Tiendas;
import pe.edu.upc.BestPrice.servicesinterfaces.ITiendasService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tiendas")
public class TiendasController {

    @Autowired
    private ITiendasService Ts;

    @GetMapping("listartiendas")
    public List<TiendasDTO> listarTienda() {
        return Ts.listarTiendas().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,TiendasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("registrarTienda")
    public void RegistrarTienda(@RequestBody TiendasDTO tdtos) {
        ModelMapper m=new ModelMapper();
        Tiendas t=m.map(tdtos,Tiendas.class);
        Ts.insert(t);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarIdTienda(@PathVariable("id") Integer id) {
        Tiendas tdtos = Ts.listarIdTiendas(id);
        if (tdtos == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de tiendas" + id);
        }
        ModelMapper m = new ModelMapper();
        TiendasDTO tdt = m.map(tdtos, TiendasDTO.class);
        return ResponseEntity.ok(tdt);
    }
}
