package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO criarCliente(Cliente cliente) {
        if (clienteRepository.existsByNome(cliente.getNome()) &&
                clienteRepository.existsByEmail(cliente.getEmail())
        ) {
            throw new IllegalStateException("A combinação de nome e email já existe!");
        }
        clienteRepository.save(cliente);
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail()
        );

    }
}
