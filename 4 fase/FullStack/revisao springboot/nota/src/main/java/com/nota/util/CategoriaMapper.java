package com.nota.util;

import com.nota.dto.CategoriaDTO;
import com.nota.entities.Categoria;

public class CategoriaMapper {
    public static CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao()
        );
    }

    public static Categoria toEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setId(categoriaDTO.getId());
        categoria.setNome(categoriaDTO.getNome());
        categoria.setDescricao(categoriaDTO.getDescricao());
        return categoria;
    }
}
