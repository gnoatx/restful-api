package com.api.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.restful.classes.Cliente;
import com.api.restful.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
