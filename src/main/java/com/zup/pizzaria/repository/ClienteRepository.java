package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByNome(String nome);
    boolean existsByEmail(String email);
}
