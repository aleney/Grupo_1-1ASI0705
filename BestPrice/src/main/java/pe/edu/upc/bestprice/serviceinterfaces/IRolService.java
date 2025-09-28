package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.Rol;

import java.util.List;

public interface IRolService {
    public List<Rol> listarRoles();
    public void insertarRol(Rol rol);
}
