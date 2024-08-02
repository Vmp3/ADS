package com.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nota.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
