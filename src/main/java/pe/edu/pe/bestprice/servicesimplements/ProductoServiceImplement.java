package pe.edu.pe.bestprice.servicesimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.bestprice.repositories.IProductoRepository;

@Service
public class ProductoServiceImplement implements IProductoRepository {

    @Autowired
    private IProductoRepository Pr;

}
