package com.zup.pizzaria.controllers;

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
    public ResponseEntity<?> criarCliente(@Validated @RequestBody Cliente cliente) {

        try {
            ClienteUtil.clienteUtil(cliente.getNome(), cliente.getEmail(), cliente.getTelefone());
            Cliente novoCliente = clienteRepository.save(cliente);
            return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
        } catch(IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());           
        
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

}