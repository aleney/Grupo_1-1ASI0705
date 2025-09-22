package pe.edu.pe.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.pe.bestprice.dtos.ProductoDTO;
import pe.edu.pe.bestprice.entities.Producto;
import pe.edu.pe.bestprice.servicesinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService Ps;

    @GetMapping
    public List<ProductoDTO> Listar(){
        return Ps.List().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,ProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/Registrar")
    public void Registar(@RequestBody ProductoDTO dtos){
        ModelMapper m=new ModelMapper();
        Producto prodc=m.map(dtos,Producto.class);
        Ps.insert(prodc);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Producto prodc=Ps.listId(id);
        if(prodc==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de producto" + id);
        }
        ModelMapper m=new ModelMapper();
        ProductoDTO dtos=m.map(prodc,ProductoDTO.class);
        return ResponseEntity.ok(dtos);
    }

}
