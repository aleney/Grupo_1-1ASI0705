package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.RolDTO;
import pe.edu.upc.bestprice.entities.Rol;
import pe.edu.upc.bestprice.serviceinterfaces.IRolService;

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
    @PreAuthorize("hasAuthority('administrador')")
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m=new ModelMapper();
        Rol soft=m.map(dto,Rol.class);
        rolService.insertarRol(soft);
    }
}
