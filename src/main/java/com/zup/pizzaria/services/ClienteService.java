package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente criarCliente(ClienteDTO clienteDTO) throws Exception {

        if (clienteRepository.existsByEmail(clienteDTO.getEmailCliente())) {
            throw new IllegalArgumentException("O e-mail já está cadastrado.");
        }
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNomeCliente());
        cliente.setTelefone(cliente.getTelefone());
        cliente.setEmail(cliente.getEmail());
        return clienteRepository.save(cliente);
    }

}
