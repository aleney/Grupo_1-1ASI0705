package pe.edu.upc.apibestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.apibestprice.dtos.UsuarioDTOInsert;
import pe.edu.upc.apibestprice.entities.Usuario;
import pe.edu.upc.apibestprice.serviceinterfaces.IUsuarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listar")
    public List<UsuarioDTOInsert> listarUsuarios() {
        return service.listarUsuarios().stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, UsuarioDTOInsert.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertarUsuario(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        service.insertarUsuario(u);
    }

    @GetMapping("/busquedas")
    public ResponseEntity<?> buscarUsuario(@RequestParam String n) {
        List<Usuario> usuarios = service.buscarUsuario(n);
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios: " + n);
        }
        List<UsuarioDTOInsert> listaDTO = usuarios.stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, UsuarioDTOInsert.class);
        }).collect(Collectors.toList());
        return ResponseEntity.ok(listaDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario prov = service.listarId(id);
        if (prov == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTOInsert dto = m.map(prov, UsuarioDTOInsert.class);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Usuario u = service.listarId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping
    public ResponseEntity<String> editar(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m = new ModelMapper();
        Usuario p = m.map(dto, Usuario.class);
        Usuario existente = service.listarId(p.getIdUsuario());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + p.getIdUsuario());
        }
        service.edit(p);
        return ResponseEntity.ok("Registro con ID " + p.getIdUsuario() + " modificado correctamente.");
    }
}
