package com.nota.util;

import com.nota.dto.ProdutoDTO;
import com.nota.entities.Produto;

public class ProdutoMapper {
    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO( produto.getId(), produto.getNome(), produto.getValor());
    }

    public static Produto toEntity(ProdutoDTO produtoDTO) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());
        return produto;
    }
}
