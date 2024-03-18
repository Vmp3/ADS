package com.carros.repository.JDBC;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.carros.model.Carro;
import com.carros.repository.CarroRepository;
@Repository
public class CarroRepositoryJDBC implements CarroRepository {

    @Override
    public String save(Carro carros) {
        
        return"";
    }

    @Override
    public List<Carro> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public void update(Long id, Carro carro) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}


