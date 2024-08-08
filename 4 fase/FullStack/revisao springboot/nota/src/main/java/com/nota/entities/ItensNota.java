package com.nota.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "itens_nota")
public class ItensNota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", referencedColumnName = "id")
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "nota_id", referencedColumnName = "id")
    private Nota nota;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ItensNota() {
    }

    public ItensNota(Produto produto, Nota nota, Integer quantidade) {
        this.produto = produto;
        this.nota = nota;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
