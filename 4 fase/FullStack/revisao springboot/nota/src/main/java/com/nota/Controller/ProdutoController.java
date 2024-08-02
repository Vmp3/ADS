package com.nota.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nota.dto.ProdutoDTO;
import com.nota.entities.Produto;
import com.nota.service.ProdutoService;
import com.nota.util.ProdutoMapper;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoDTO criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        Produto produtoCriado = produtoService.criarProduto(produto);
        return ProdutoMapper.toDTO(produtoCriado);
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
        return produtoService.obterProdutoPorId(id).map(produto -> ResponseEntity.ok(ProdutoMapper.toDTO(produto)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO){
        Produto produto = ProdutoMapper.toEntity(produtoDTO);
        Produto produtoAtualizado = produtoService.atualizarProduto(id, produto);
        if (produtoAtualizado != null) {
            return ResponseEntity.ok(ProdutoMapper.toDTO(produtoAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        boolean produtoDeletado = produtoService.deletarProduto(id);
        if (produtoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
