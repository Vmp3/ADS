package com.nota.dto;

import java.time.LocalDate;
import java.util.List;

public class NotaDTO {

    private Long id;
    private Long clienteId;
    private LocalDate data;
    private Double valorTotal;
    private List<ItensNotaDTO> itensNota;

    public NotaDTO() {
    }

    public NotaDTO(Long id, Long clienteId, LocalDate data, Double valorTotal, List<ItensNotaDTO> itensNota) {
        this.id = id;
        this.clienteId = clienteId;
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

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
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

    public List<ItensNotaDTO> getItensNota() {
        return itensNota;
    }

    public void setItensNota(List<ItensNotaDTO> itensNota) {
        this.itensNota = itensNota;
    }
}
