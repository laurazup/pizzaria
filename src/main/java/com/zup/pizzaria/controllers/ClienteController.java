package com.zup.pizzaria.controllers;

import com.zup.pizzaria.dtos.ClienteDTO;
import com.zup.pizzaria.models.Cliente;
import com.zup.pizzaria.repository.ClienteRepository;
import com.zup.pizzaria.utils.ClienteUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
@Validated
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    public  ClienteController(ClienteRepository clienteRepository){}

    @PostMapping
    public ResponseEntity<?> criarCliente(@Validated @RequestBody ClienteDTO clienteDTO) {
        try {

            ClienteUtil.validarCliente(clienteDTO);

            if (clienteRepository.existsByEmail(clienteDTO.getEmailCliente())) {
                throw new IllegalArgumentException("O e-mail já está cadastrado.");
            }

            // Criação do objeto Cliente com os dados do DTO
            Cliente cliente = new Cliente();
            cliente.setNome(clienteDTO.getNomeCliente());
            cliente.setEmail(clienteDTO.getEmailCliente());
            cliente.setTelefone(clienteDTO.getTelefoneCliente());

            Cliente novoCliente = clienteRepository.save(cliente);

            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {

            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Tratamento de exceções de validação
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

}