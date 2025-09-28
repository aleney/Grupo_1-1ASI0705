package pe.edu.upc.bestprice.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entitie.AuthGoogle;
import pe.edu.upc.bestprice.repositories.IAuthGoogleRepository;
import pe.edu.upc.bestprice.serviceinterfaces.IAuthGoogleService;

import java.util.List;

@Service
public class AuthGoogleServiceImplement implements IAuthGoogleService {

    @Autowired
    private IAuthGoogleRepository repository;

    @Override
    public List<AuthGoogle> list() {
        return repository.findAll();
    }

    @Override
    public void insert(AuthGoogle authGoogle) {
        repository.save(authGoogle);
    }
}
