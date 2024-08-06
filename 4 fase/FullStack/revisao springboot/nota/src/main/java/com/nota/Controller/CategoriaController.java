package com.nota.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nota.dto.CategoriaDTO;
import com.nota.entities.Categoria;
import com.nota.service.CategoriaService;
import com.nota.util.CategoriaMapper;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public CategoriaDTO criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);
        Categoria categoriaCriada = categoriaService.criarCategoria(categoria);
        return CategoriaMapper.toDTO(categoriaCriada);
    }

    @GetMapping
    public List<CategoriaDTO> obterTodasCategorias() {
        List<Categoria> categorias = categoriaService.obterTodasCategorias();
        return categorias.stream().map(CategoriaMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> obterCategoriaPorId(@PathVariable Long id) {
        return categoriaService.obterCategoriaPorId(id)
                .map(categoria -> ResponseEntity.ok(CategoriaMapper.toDTO(categoria)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = CategoriaMapper.toEntity(categoriaDTO);
        Categoria categoriaAtualizada = categoriaService.atualizarCategoria(id, categoria);
        if (categoriaAtualizada != null) {
            return ResponseEntity.ok(CategoriaMapper.toDTO(categoriaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        boolean categoriaDeletada = categoriaService.deletarCategoria(id);
        if (categoriaDeletada) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
