package com.carros.repository.JDBC;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.carros.model.Carro;
import com.carros.repository.CarroRepository;

@Repository
public class CarroRepositoryJDBC implements CarroRepository {

    private final JdbcTemplate jdbcTemplate;

    public CarroRepositoryJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Carro carros) {
        String sql = "INSERT INTO entrada (nome, fabricante, placa  ) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, carros.getNome(), carros.getFabricante(), carros.getPlaca());
    }

    @Override
    public List<Carro> findAll() {

        String sql = "SELECT * FROM entrada";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Carro carro = new Carro
                            (rs.getString("nome"), 
                            rs.getString("fabricante"),
                            rs.getString("placa"), 
                            rs.getTimestamp("dataEntrada"),
                            rs.getLong("id")
                            );
            return carro;
        });
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
