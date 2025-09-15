package pe.edu.pe.bestprice.servicesinterfaces;

import pe.edu.pe.bestprice.entities.AuthGoogle;

import java.util.List;

public interface IAuthGoogleService {
    public List<AuthGoogle> list();
    public void insert(AuthGoogle authGoogle);
}
