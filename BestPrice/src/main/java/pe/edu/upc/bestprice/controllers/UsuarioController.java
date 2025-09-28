package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.UsuarioDTOInsert;
import pe.edu.upc.bestprice.dtos.UsuarioDTOList;
import pe.edu.upc.bestprice.entities.Usuario;
import pe.edu.upc.bestprice.serviceinterfaces.IUsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('administrador')")
    public ResponseEntity<?> listar() {
        List<String[]> usuarios = service.listar();
        List<UsuarioDTOList> listaUsuarios = new ArrayList<>();

        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios registrados");
        }
        for (String[] columna : usuarios) {
            UsuarioDTOList dto = new UsuarioDTOList();
            dto.setNombre(columna[0]);
            dto.setEmail(columna[1]);
            dto.setEstado(Boolean.parseBoolean(columna[2]));
            dto.setTipoUsuario(columna[3]);
            listaUsuarios.add(dto);
        }
        return ResponseEntity.ok(listaUsuarios);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('administrador')")
    public void insertarUsuario(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        service.insertarUsuario(u);
    }

    @GetMapping("/buscar")
    public ResponseEntity<?> buscarUsuario(@RequestParam String nombre) {
        List<String[]> usuarios = service.buscarUsuario(nombre);
        if (usuarios.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios: " + nombre);
        }

        List<UsuarioDTOList> listaDTO = new ArrayList<>();
        for (String[] columna : usuarios) {
            UsuarioDTOList dto = new UsuarioDTOList();
            dto.setNombre(columna[0]);
            dto.setEmail(columna[1]);
            dto.setEstado(Boolean.parseBoolean(columna[2]));
            dto.setTipoUsuario(columna[3]);
            listaDTO.add(dto);
        }
        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> listarId(@PathVariable("id") Integer id) {
        Usuario user = service.listarId(id);
        if (user == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        ModelMapper m = new ModelMapper();
        UsuarioDTOList dto = m.map(user, UsuarioDTOList.class);
        return ResponseEntity.ok(dto);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('administrador')")

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
    @PreAuthorize("hasAuthority('administrador')")
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
