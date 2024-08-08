package com.nota.dto;

public class ItensNotaDTO {

    private Long id;
    private Long produtoId;
    private Long notaId;
    private Integer quantidade;

    public ItensNotaDTO() {
    }

    public ItensNotaDTO(Long id, Long produtoId, Long notaId, Integer quantidade) {
        this.id = id;
        this.produtoId = produtoId;
        this.notaId = notaId;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public Long getNotaId() {
        return notaId;
    }

    public void setNotaId(Long notaId) {
        this.notaId = notaId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
