package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.CanastaDetalle;

import java.util.List;

public interface ICanastaDetalleService {
    public List<CanastaDetalle> buscarService(String nombre);  // Buscar detalles por nombre
    public void insert(CanastaDetalle cd);  // Insertar detalle
    public List<CanastaDetalle> list();  // Listar todos los detalles
    public CanastaDetalle listId(String id);  // Obtener detalle por ID

    // Cambia el tipo de "id" a Integer, ya que idCanastaDetalle es Integer en la entidad
    CanastaDetalle listId(Integer id);

    public void edit(CanastaDetalle cd);  // Editar detalle
}

