package com.nota.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nota.dto.ProdutoDTO;
import com.nota.entities.Produto;
import com.nota.entities.Categoria;
import com.nota.service.ProdutoService;
import com.nota.service.CategoriaService;
import com.nota.util.ProdutoMapper;
import com.nota.Exception.CategoriaInvalidaException;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Categoria categoria = categoriaService.obterCategoriaPorNome(produtoDTO.getCategoriaNome());
        if (categoria == null) {
            throw new CategoriaInvalidaException("Categoria inválida");
        }
        Produto produto = ProdutoMapper.toEntity(produtoDTO, categoria);
        Produto produtoCriado = produtoService.criarProduto(produto);
        return ResponseEntity.ok(ProdutoMapper.toDTO(produtoCriado));
    }

    @GetMapping
    public List<ProdutoDTO> obterTodosprodutos() {
        List<Produto> produtos = produtoService.obterTodosProdutos();
        List<ProdutoDTO> produtoDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoDTOs.add(ProdutoMapper.toDTO(produto));
        }
        return produtoDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> obterProdutoPorId(@PathVariable Long id) {
        return produtoService.obterProdutoPorId(id)
                .map(produto -> ResponseEntity.ok(ProdutoMapper.toDTO(produto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/categoria/{categoriaNome}")
    public ResponseEntity<List<ProdutoDTO>> obterProdutosPorCategoria(@PathVariable String categoriaNome) {
        Categoria categoria = categoriaService.obterCategoriaPorNome(categoriaNome);
        if (categoria == null) {
            throw new CategoriaInvalidaException("Categoria inválida");
        }
        List<Produto> produtos = produtoService.obterProdutosPorCategoria(categoria);
        List<ProdutoDTO> produtoDTOs = new ArrayList<>();
        for (Produto produto : produtos) {
            produtoDTOs.add(ProdutoMapper.toDTO(produto));
        }
        return ResponseEntity.ok(produtoDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Categoria categoria = categoriaService.obterCategoriaPorNome(produtoDTO.getCategoriaNome());
        if (categoria == null) {
            throw new CategoriaInvalidaException("Categoria inválida");
        }
        Produto produto = ProdutoMapper.toEntity(produtoDTO, categoria);
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        boolean produtoDeletado = produtoService.deletarProduto(id);
        if (produtoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
