package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.entities.AuthGoogle;
import pe.edu.pe.bestprice.repositories.IAuthGoogleRepository;
import pe.edu.pe.bestprice.servicesinterfaces.IAuthGoogleService;

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
