package com.carros.model;

import java.sql.Timestamp;

public class Carro {
    private Long id_carro;
    private String nome;
    private String fabricante;
    private String placa;
    private Timestamp dataEntrada;

    public Carro(String nome, String fabricante, String placa, Timestamp dataEntrada, Long id_carro) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.placa = placa;
        this.dataEntrada = dataEntrada;
        this.id_carro = id_carro;
    }

    public long getId_carro() {
        return id_carro;
    }

    public void setId_carro(long id_carro) {
        this.id_carro = id_carro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Timestamp getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Timestamp dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

}
