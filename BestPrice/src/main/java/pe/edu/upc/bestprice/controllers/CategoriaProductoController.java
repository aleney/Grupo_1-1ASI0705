package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.CategoriaProductoDTO;
import pe.edu.upc.bestprice.entities.CategoriaProducto;
import pe.edu.upc.bestprice.serviceinterfaces.ICategoriaProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria-producto")
public class CategoriaProductoController {

    @Autowired
    private ICategoriaProductoService service;

    @GetMapping
    public List<CategoriaProductoDTO> Listar(){
        return service.listarCategoriaProducto().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,CategoriaProductoDTO.class);
        }).collect(Collectors.toList());
    }
    @PostMapping("/Registrar")
    public void Registar(@RequestBody CategoriaProductoDTO dtos){
        ModelMapper m=new ModelMapper();
        CategoriaProducto ctp=m.map(dtos,CategoriaProducto.class);
        service.insertarCateProduct(ctp);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        CategoriaProducto ctps=service.listId(id);
        if(ctps==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de la Categoria del producto" + id);
        }
        ModelMapper m=new ModelMapper();
        CategoriaProductoDTO cpdtos=m.map(ctps,CategoriaProductoDTO.class);
        return ResponseEntity.ok(cpdtos);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        CategoriaProducto Ctp = service.listId(id);
        if (Ctp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> modificar(@RequestBody CategoriaProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        CategoriaProducto ctp = m.map(dto, CategoriaProducto.class);
        CategoriaProducto existente = service.listId(ctp.getIdCategoriaProducto());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + ctp.getIdCategoriaProducto());
        }

        // Actualización si pasa validaciones
        service.update(ctp);
        return ResponseEntity.ok("Registro con ID " + ctp.getIdCategoriaProducto() + " modificado correctamente.");
    }
}
