package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.UsuarioDTOEstado;
import pe.edu.upc.bestprice.dtos.UsuarioDTOInsert;
import pe.edu.upc.bestprice.dtos.UsuarioDTOList;
import pe.edu.upc.bestprice.entities.Usuario;
import pe.edu.upc.bestprice.serviceinterfaces.IUsuarioService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService service;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UsuarioDTOList> listar(){
        return service.listarUsuarios().stream().map(a->{
            ModelMapper m=new ModelMapper();
            return m.map(a,UsuarioDTOList.class);
        }).collect(Collectors.toList());
    }

    @PostMapping("/insertar")
    public void insertarUsuario(@RequestBody UsuarioDTOInsert dto) {
        ModelMapper m=new ModelMapper();
        Usuario u=m.map(dto,Usuario.class);
        service.insertarUsuario(u);
    }

    @GetMapping("/buscar")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> buscarUsuario(@RequestParam String n) {
        List<Usuario> us = service.buscarUsuario(n);

        if (us.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron tiendas de nombre o caracter: " + n);
        }

        List<UsuarioDTOInsert> listaDTO = us.stream().map(a -> {
            ModelMapper m = new ModelMapper();
            return m.map(a, UsuarioDTOInsert.class);
        }).collect(Collectors.toList());

        return ResponseEntity.ok(listaDTO);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
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
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Usuario u = service.listarId(id);
        if (u == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        service.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAnyAuthority('ADMIN','CONSUMER','SELLER')")
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

    @GetMapping("/estado")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> UsuariosPorEstado() {
        List<String[]> usEst = service.filtrarUsuariosPorEstado();
        List<UsuarioDTOEstado> usEstado = new ArrayList<>();

        if (usEst.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se encontraron usuarios registrados");
        }

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd HH:mm:ss")
                .appendFraction(ChronoField.MICRO_OF_SECOND, 1, 6, true)
                .toFormatter();

        //columna -> Item de la lista de elementos que retorna monto
        for (String[] columna : usEst) {
            UsuarioDTOEstado dto = new UsuarioDTOEstado();
            dto.setIdUsuario(Integer.parseInt(columna[0]));   // idUsuario
            dto.setNombre(columna[1]);                        // nombre
            dto.setCreatedAt(LocalDateTime.parse(columna[2], formatter)); // createdAt
            dto.setEstado(Boolean.parseBoolean(columna[3]));   // estado

            usEstado.add(dto);
        }
        return ResponseEntity.ok(usEstado);
    }
}

