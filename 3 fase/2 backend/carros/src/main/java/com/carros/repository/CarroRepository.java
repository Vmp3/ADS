package com.carros.repository;
import com.carros.model.Carro;
public interface CarroRepository {
    void save(Carro carros);
    List<Carro> findAll();
    void update (Long id, Carro carro,);
    void delete (Long id);
}
