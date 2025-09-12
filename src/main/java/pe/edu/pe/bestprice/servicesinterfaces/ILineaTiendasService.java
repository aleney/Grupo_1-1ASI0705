package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.LineaTiendas;

import java.util.List;

public interface ILineaTiendasService {
    public List<LineaTiendas>list();
    public void insert(LineaTiendas lt);
    public LineaTiendas ListId(int id);
    public void delete(int id);
    public void update(LineaTiendas lt);
    public List<LineaTiendas> buscarService(String nombre);
}
