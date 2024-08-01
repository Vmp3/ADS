package com.nota.dto;


public class ClienteDTO {
    private long id;
    private String nome;
    private String email;
    private EnderecoDTO enderecoDTO;

    public ClienteDTO() {
    }

    public ClienteDTO(long id, String nome, String email, EnderecoDTO enderecoDTO) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.enderecoDTO = enderecoDTO;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public EnderecoDTO getEnderecoDTO() {
        return enderecoDTO;
    }

    public void setEnderecoDTO(EnderecoDTO enderecoDTO) {
        this.enderecoDTO = enderecoDTO;
    }
    
}
