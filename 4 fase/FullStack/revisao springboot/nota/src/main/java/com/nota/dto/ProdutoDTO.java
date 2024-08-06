package com.nota.dto;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double valor;
    private String categoriaNome;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Long id, String nome, Double valor, String categoriaNome) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoriaNome = categoriaNome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }
}
