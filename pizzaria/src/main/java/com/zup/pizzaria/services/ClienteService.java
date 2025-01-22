package com.zup.pizzaria.services;

import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    // Metodo para listar todos os clientes e convertê-los em DTOs
    public List<ClienteDTO> listarClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        // Convertendo a lista de entidades para uma lista de DTOs
        return clientes.stream()
                .map(cliente -> new ClienteDTO(cliente.getNome(), cliente.getEmail(), cliente.getTelefone()))
                .collect(Collectors.toList());
    }

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO) {
        // Validações
        if (clienteDTO.getNomeCliente() == null || clienteDTO.getNomeCliente().isBlank()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser nulo ou em branco.");
        }

        if (clienteDTO.getEmailCliente() == null || clienteDTO.getEmailCliente().isBlank()) {
            throw new IllegalArgumentException("O email do cliente não pode ser nulo ou em branco.");
        }

        if (clienteDTO.getTelefone() <= 9999999) {
            throw new IllegalArgumentException("O telefone do cliente deve ser maior que 9999999.");
        }

        // Convertendo o DTO para a entidade Cliente
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDTO.getNomeCliente());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setEmail(clienteDTO.getEmailCliente());

        // Salvando no banco de dados
        Cliente clienteSalvo = clienteRepository.save(cliente);

        // Retornando o cliente salvo como DTO
        return new ClienteDTO(clienteSalvo.getNome(), clienteSalvo.getEmail(), clienteSalvo.getTelefone());
    }
}
