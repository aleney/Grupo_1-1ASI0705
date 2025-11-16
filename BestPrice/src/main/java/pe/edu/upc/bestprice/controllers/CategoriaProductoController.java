package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping("/listar")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE','SELLER')")
    public ResponseEntity<?> listar() {
        List<CategoriaProductoDTO> lista = service.listarCategoriaProducto().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, CategoriaProductoDTO.class);
        }).collect(Collectors.toList());

        if (lista.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron categorías de producto registradas.");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<String> insertar(@RequestBody CategoriaProductoDTO dto) {
        if (dto == null) {
            return ResponseEntity.badRequest()
                    .body("El cuerpo de la solicitud está vacío o es inválido.");
        }

        try {
            ModelMapper m = new ModelMapper();
            CategoriaProducto categoria = m.map(dto, CategoriaProducto.class);
            service.insertarCateProduct(categoria);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("Categoría de producto registrada correctamente.");
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body("Error al registrar la categoría de producto. Verifica que los datos enviados sean correctos.");
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','CLIENTE','SELLER')")
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
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
    public ResponseEntity<String> eliminar(@PathVariable("id") Integer id) {
        CategoriaProducto Ctp = service.listId(id);
        if (Ctp == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAnyAuthority('ADMIN','SELLER')")
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