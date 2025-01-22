package com.zup.pizzaria.repository;

import com.zup.pizzaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Método para verificar se existe um cliente com o e-mail fornecido
    boolean existsByEmail(String email);

}
