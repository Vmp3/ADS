package com.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nota.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}
