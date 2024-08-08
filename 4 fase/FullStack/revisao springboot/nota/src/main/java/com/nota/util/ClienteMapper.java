package com.nota.util;

import com.nota.dto.ClienteDTO;
import com.nota.dto.EnderecoDTO;
import com.nota.entities.Cliente;
import com.nota.entities.Endereco;

public class ClienteMapper {

    public static ClienteDTO toDTO(Cliente cliente) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(cliente.getEndereco().getId());
        enderecoDTO.setCep(cliente.getEndereco().getCep());
        enderecoDTO.setNumero(cliente.getEndereco().getNumero());
        enderecoDTO.setComplemento(cliente.getEndereco().getComplemento());

        ClienteDTO clienteDTO = new ClienteDTO(cliente.getNome(), cliente.getEmail(), enderecoDTO);
        clienteDTO.setId(cliente.getId());
        return clienteDTO;
    }

    public static Cliente toEntity(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());

        if (clienteDTO.getEnderecoDTO() != null) {
            Endereco endereco = new Endereco();
            endereco.setId(clienteDTO.getEnderecoDTO().getId());
            endereco.setCep(clienteDTO.getEnderecoDTO().getCep());
            endereco.setNumero(clienteDTO.getEnderecoDTO().getNumero());
            endereco.setComplemento(clienteDTO.getEnderecoDTO().getComplemento());
            cliente.setEndereco(endereco);
        }

        return cliente;
    }
}