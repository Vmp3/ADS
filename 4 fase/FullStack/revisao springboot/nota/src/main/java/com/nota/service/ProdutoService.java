package com.nota.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nota.entities.Produto;
import com.nota.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> obterTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Optional<Produto> obterProdutoPorId(Long id){
        return produtoRepository.findById(id);
    }

    public Produto atualizarProduto(Long id, Produto produto){
        Optional<Produto> produtoExistente = produtoRepository.findById(id);
        if (produtoExistente.isPresent()){
            Produto p = produtoExistente.get();
            p.setNome(produto.getNome());
            p.setValor(produto.getValor());
            return produtoRepository.save(p);
        } else {
            return null;
        }
    }
    
    public boolean deletarProduto(Long id){
        Optional<Produto> produtoExistente = produtoRepository.findById(id); // Correção aqui
        if (produtoExistente.isPresent()){
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
