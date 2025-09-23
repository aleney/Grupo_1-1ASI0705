package pe.edu.upc.apibestprice.serviceinterfaces;

import pe.edu.upc.apibestprice.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listarRoles();
    public void insertarRol(Rol rol);
}
