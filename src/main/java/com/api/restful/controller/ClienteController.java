package com.api.restful.controller;

import org.springframework.web.bind.annotation.*;

import com.api.restful.classes.Cliente;

import java.util.UUID;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    // Get all clients
    @GetMapping
    public String getAllClientes() {
        if(!Cliente.clientes.isEmpty()) {
            // Usar o Gson para retornar os objetos
            return Cliente.clientes.toString();
        } else {
            return "Não há clientes cadastrados.";
        }
    }

    @PostMapping
    public String addCliente(@RequestBody Cliente cliente) {

        System.out.println("Adicionando cliente...");

        Cliente.clientes.add(cliente);
        return "Cliente adicionado com sucesso!";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                return cliente.toString();
            }
        }
        return "Cliente não encontrado.";
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable UUID id) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                Cliente.clientes.remove(cliente);
                return "Cliente removido com sucesso!";
            }
        }
        return "Cliente não encontrado.";
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable UUID id, @RequestBody Cliente clienteAtualizado) {
        for (Cliente cliente : Cliente.clientes) {
            if (cliente.getId().equals(id)) {
                cliente.setNome(clienteAtualizado.getNome());
                cliente.setCpf(clienteAtualizado.getCpf());
                cliente.setEndereco(clienteAtualizado.getEndereco());
                cliente.setTelefone(clienteAtualizado.getTelefone());
                cliente.setEmail(clienteAtualizado.getEmail());
                cliente.setDataNascimento(clienteAtualizado.getDataNascimento());

                return "Cliente atualizado com sucesso!";
            }
        }
        return "Cliente não encontrado";
    }
}
