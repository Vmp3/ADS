package com.carros.repository.JDBC;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.carros.model.Carro;
import com.carros.repository.CarroRepository;
@Repository
public class CarroRepositoryJDBC implements CarroRepository {

    private final JdbcTemplate jdbcTemplate;
    public CarroRepositoryJDBC(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Carro carros) {
        String sql= "INSERT INTO entrada (nome, fabricante, placa) VALUE (?, ?, ?)";
        jdbcTemplate.update(sql, carros.getNome(), carros.getFabricante(), carros.getPlaca());
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


