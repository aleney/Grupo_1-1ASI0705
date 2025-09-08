package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.LineaTiendas;

import java.util.List;

public interface ILineaTiendasService {
    public List<LineaTiendas>list();
    public void insert(LineaTiendas lt);
}
