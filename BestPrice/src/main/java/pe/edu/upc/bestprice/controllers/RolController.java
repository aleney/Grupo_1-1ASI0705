package pe.edu.upc.bestprice.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.bestprice.dtos.RolDTO;
import pe.edu.upc.bestprice.entities.Rol;
import pe.edu.upc.bestprice.serviceinterfaces.IRolService;

import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping("/listar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listar() {
        List<RolDTO> lista = rolService.listarRoles()
                .stream()
                .map(a -> new ModelMapper().map(a, RolDTO.class))
                .collect(Collectors.toList());

        if (lista.isEmpty()) {
            Map<String, String> respuesta = new HashMap<>();
            respuesta.put("mensaje", "No existen registros");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping("/insertar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void insertar(@RequestBody RolDTO dto) {
        ModelMapper m=new ModelMapper();
        Rol soft=m.map(dto,Rol.class);
        rolService.insertarRol(soft);
    }

    @PutMapping("/editar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<String> editar(@RequestBody RolDTO dto) {
        ModelMapper m = new ModelMapper();
        Rol r = m.map(dto, Rol.class);
        Rol existente = rolService.listarId(r.getIdRol());
        if (existente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No se puede modificar. No existe un registro con el ID: " + r.getIdRol());
        }
        rolService.edit(r);
        return ResponseEntity.ok("Registro con ID " + r.getIdRol() + " modificado correctamente.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")

    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        Rol r = rolService.listarId(id);
        if (r == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No existe un registro con el ID: " + id);
        }
        rolService.delete(id);
        return ResponseEntity.ok("Registro con ID " + id + " eliminado correctamente.");
    }
}
