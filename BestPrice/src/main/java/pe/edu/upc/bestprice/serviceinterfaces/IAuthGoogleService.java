package pe.edu.upc.bestprice.serviceinterfaces;

import pe.edu.upc.bestprice.entitie.AuthGoogle;

import java.util.List;

public interface IAuthGoogleService {
    public List<AuthGoogle> list();
    public void insert(AuthGoogle authGoogle);
}
