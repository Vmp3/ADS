package com.nota.util;

import com.nota.dto.ProdutoDTO;
import com.nota.entities.Produto;
import com.nota.entities.Categoria;

public class ProdutoMapper {

    public static ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getValor(), produto.getCategoria().getNome());
    }

    public static Produto toEntity(ProdutoDTO produtoDTO, Categoria categoria) {
        Produto produto = new Produto();
        produto.setId(produtoDTO.getId());
        produto.setNome(produtoDTO.getNome());
        produto.setValor(produtoDTO.getValor());
        produto.setCategoria(categoria);
        return produto;
    }
}
