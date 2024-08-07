package com.carros.repository;
import java.util.List;

import com.carros.model.Carro;
public interface CarroRepository {
    void save(Carro carro);
    List<Carro> findAll();
    void update (Long id, Carro carro);
    void delete (Long id);
}
