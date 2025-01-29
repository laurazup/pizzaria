package com.zup.pizzaria;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Autowired
    private ClienteService clienteService;

    @Override
    public void run(String... args) throws Exception {
        try {
            // Exemplo de criação de um cliente
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setNomeCliente("João Silva");
            clienteDTO.setEmailCliente("joao.silva@email.com");
            clienteDTO.setTelefoneCliente("12345678");

            Cliente cliente = clienteService.criarCliente(clienteDTO);
            System.out.println("Cliente criado com sucesso: " + cliente);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao criar cliente: " + e.getMessage());
        }
    }
}

