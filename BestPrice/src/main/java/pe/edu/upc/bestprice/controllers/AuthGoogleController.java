package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.AuthGoogleDTOInsert;
import pe.edu.upc.bestprice.dtos.AuthGoogleDTOList;
import pe.edu.upc.bestprice.entities.AuthGoogle;
import pe.edu.upc.bestprice.servicesinterfaces.IAuthGoogleService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/Google")
public class AuthGoogleController {
    
    @Autowired
    private IAuthGoogleService service;

    @GetMapping("/listar")
    public List<AuthGoogleDTOList> listar(){
        return service.list().stream().map(a->{
            ModelMapper m = new ModelMapper();
            return m.map(a,AuthGoogleDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertar(@RequestBody AuthGoogleDTOInsert dto){
        ModelMapper m = new ModelMapper();
        AuthGoogle g = m.map(dto,AuthGoogle.class);
        service.insert(g);
    }

}
