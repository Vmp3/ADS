package com.nota.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "valor_total")
    private Double valorTotal;

    @OneToMany(mappedBy = "nota", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItensNota> itensNota;

    public Nota() {
    }

    public Nota(Cliente cliente, LocalDate data, Double valorTotal, List<ItensNota> itensNota) {
        this.cliente = cliente;
        this.data = data;
        this.valorTotal = valorTotal;
        this.itensNota = itensNota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<ItensNota> getItensNota() {
        return itensNota;
    }

    public void setItensNota(List<ItensNota> itensNota) {
        this.itensNota = itensNota;
    }
}
