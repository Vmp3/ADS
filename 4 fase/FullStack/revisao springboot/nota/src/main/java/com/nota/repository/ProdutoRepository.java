package com.nota.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nota.entities.Produto;
import com.nota.entities.Categoria;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoria(Categoria categoria);
}
