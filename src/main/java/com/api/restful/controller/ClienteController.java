package com.api.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.restful.classes.Cliente;
import com.api.restful.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;    
    
    // Get Cliente by id
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }

    // Get all Clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> getAll() {
        List<Cliente> clientes = clienteService.getAll();
        return ResponseEntity.ok(clientes);
    }

    // Create new Cliente
    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
        Cliente clienteNovo = clienteService.create(cliente);
        return ResponseEntity.ok(clienteNovo);
    }

    // Update Cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente dadosAtualizados) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        cliente.setNome(dadosAtualizados.getNome());
        cliente.setCpf(dadosAtualizados.getCpf());
        cliente.setEndereco(dadosAtualizados.getEndereco());
        cliente.setTelefone(dadosAtualizados.getTelefone());
        cliente.setEmail(dadosAtualizados.getEmail());
        cliente.setDataNascimento(dadosAtualizados.getDataNascimento());

        Cliente clienteAtualizado = clienteService.create(cliente);

        return ResponseEntity.ok(clienteAtualizado);
    }

    // Delete Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Cliente cliente = clienteService.getById(id);

        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        clienteService.delete(id);
        
        return ResponseEntity.noContent().build();
    }
}
