package pe.edu.upc.bestprice.servicesinterfaces;

import pe.edu.upc.bestprice.entities.AuthGoogle;

import java.util.List;

public interface IAuthGoogleService {
    public List<AuthGoogle> list();
    public void insert(AuthGoogle authGoogle);
}
