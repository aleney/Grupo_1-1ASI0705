package pe.edu.upc.bestprice.servicesinterfaces;

import pe.edu.upc.bestprice.entities.LineaTiendas;

import java.util.List;

public interface ILineaTiendasService {
    public List<LineaTiendas>list();
    public void insert(LineaTiendas lt);
    public LineaTiendas ListId(int id);
    public void delete(int id);
    public void update(LineaTiendas lt);
    public List<LineaTiendas> buscarService(String nombre);
    public List<String[]> TiendasCreadasEn2025();
}
