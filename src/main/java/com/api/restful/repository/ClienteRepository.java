package com.api.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restful.classes.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
