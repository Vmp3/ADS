package com.nota.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nota.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
