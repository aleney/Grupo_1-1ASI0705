package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.ProductoDTO;
import pe.edu.upc.bestprice.entities.Producto;
import pe.edu.upc.bestprice.serviceinterfaces.IProductoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE','SELLER')")
    public List<ProductoDTO> Listar(){
        return service.List().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,ProductoDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/Registrar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public void Registar(@RequestBody ProductoDTO dtos){
        ModelMapper m=new ModelMapper();
        Producto prodc=m.map(dtos,Producto.class);
        service.insert(prodc);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE','SELLER')")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id){
        Producto prodc=service.listId(id);
        if(prodc==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe ningun registro de producto" + id);
        }
        ModelMapper m=new ModelMapper();
        ProductoDTO dtos=m.map(prodc,ProductoDTO.class);
        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        Producto p = service.listId(id);
        if (p == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<String> modificar(@RequestBody ProductoDTO dto) {
        ModelMapper m = new ModelMapper();
        Producto p = m.map(dto, Producto.class);
        Producto existente = service.listId(p.getIdProducto());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + p.getIdProducto());
        }

        // Actualización si pasa validaciones
        service.update(p);
        return ResponseEntity.ok("Registro con ID " + p.getIdProducto() + " modificado correctamente.");
    }

}
