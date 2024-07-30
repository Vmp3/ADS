package com.nota.dto;

public class ClienteDTO {
    private long Id;
    private String nome;
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(long id, String nome, String email) {
        Id = id;
        this.nome = nome;
        this.email = email;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
