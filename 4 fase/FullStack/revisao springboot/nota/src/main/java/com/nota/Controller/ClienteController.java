package com.nota.Controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nota.dto.ClienteDTO;
import com.nota.entities.Cliente;
import com.nota.service.ClienteService;
import com.nota.util.ClienteMapper;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO clienteDTO) {
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente clienteCriado = clienteService.criarCliente(cliente);
        return ClienteMapper.toDTO(clienteCriado);
    }

    @GetMapping
    public List<ClienteDTO> obterTodosclientes() {
        List<Cliente> clientes = clienteService.obterTodosClientes();
        List<ClienteDTO> clienteDTOs = new ArrayList<>();
        for (Cliente cliente : clientes) {
            clienteDTOs.add(ClienteMapper.toDTO(cliente));
        }
        return clienteDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> obterClientePorId(@PathVariable Long id) {
        return clienteService.obterClientePorId(id).map(cliente -> ResponseEntity.ok(ClienteMapper.toDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        Cliente cliente = ClienteMapper.toEntity(clienteDTO);
        Cliente clienteAtualizado = clienteService.atualizarCliente(id, cliente);
        if (clienteAtualizado != null) {
            return ResponseEntity.ok(ClienteMapper.toDTO(clienteAtualizado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        boolean clienteDeletado = clienteService.deletarCliente(id);
        if (clienteDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
