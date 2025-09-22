package pe.edu.upc.apibestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apibestprice.dtos.RolDTO;
import pe.edu.upc.apibestprice.entities.Rol;
import pe.edu.upc.apibestprice.serviceinterfaces.IRolService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping("/listar")
    public List<RolDTO> listar(){
        return rolService.listarRoles().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m=new ModelMapper();
        Rol soft=m.map(dto,Rol.class);
        rolService.insertarRol(soft);
    }
}
