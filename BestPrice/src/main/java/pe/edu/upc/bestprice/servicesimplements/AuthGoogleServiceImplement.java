package pe.edu.upc.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.bestprice.entities.AuthGoogle;
import pe.edu.upc.bestprice.repositories.IAuthGoogleRepository;
import pe.edu.upc.bestprice.servicesinterfaces.IAuthGoogleService;

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
