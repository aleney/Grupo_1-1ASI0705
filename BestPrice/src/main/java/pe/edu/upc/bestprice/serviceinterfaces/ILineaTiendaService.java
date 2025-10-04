package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entities.LineaTienda;

import java.util.List;

public interface ILineaTiendaService {
    public List<LineaTienda>list();
    public void insert(LineaTienda lt);
    public LineaTienda ListId(int id);
    public void delete(int id);
    public void update(LineaTienda lt);
    public List<LineaTienda> buscarService(String nombre);
    public List<String[]> TiendaCreadasEn2025();
}
