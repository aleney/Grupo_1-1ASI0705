package pe.edu.upc.BestPrice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.BestPrice.dtos.CategoriaProductoDTO;
import pe.edu.upc.BestPrice.entities.CategoriaProducto;
import pe.edu.upc.BestPrice.servicesinterfaces.ICategoriaProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoriaProductos")
public class CategoriaProductoController {

    @Autowired
    private ICategoriaProductoService Cps;

    @GetMapping
    public List<CategoriaProductoDTO> Listar(){
        return Cps.listarCategoriaProducto().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,CategoriaProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/Registrar")
    public void Registar(@RequestBody CategoriaProductoDTO dtos){
        ModelMapper m=new ModelMapper();
        CategoriaProducto ctp=m.map(dtos,CategoriaProducto.class);
        Cps.insertarCateProduct(ctp);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
       CategoriaProducto ctps=Cps.listId(id);
        if(ctps==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de la Categoria del producto" + id);
        }
        ModelMapper m=new ModelMapper();
        CategoriaProductoDTO cpdtos=m.map(ctps,CategoriaProductoDTO.class);
        return ResponseEntity.ok(cpdtos);
    }

}
