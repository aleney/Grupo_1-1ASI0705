package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.Resena;

import java.util.List;

public interface IResenaService {
    public List<Resena> list();
    public void insert(Resena resena);
    public void update(Resena resena);
    public void delete(int id);
    public Resena ListId(Integer id);
}
