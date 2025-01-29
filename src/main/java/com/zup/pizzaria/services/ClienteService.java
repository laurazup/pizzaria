package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.utils.ClienteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(ClienteDTO clienteDTO) throws Exception {
        // Criação do objeto Cliente com os dados do DTO
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNomeCliente());
        cliente.setTelefone(clienteDTO.getTelefoneCliente());
        cliente.setEmail(clienteDTO.getEmailCliente());


        ClienteUtil.validarCliente(clienteDTO);


        if (clienteRepository.existsByEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("O e-mail já está cadastrado.");
        }

        // Salva o cliente no repositório
        return clienteRepository.save(cliente);
    }
}

