package com.zup.pizzaria.dtos;

import com.zup.pizzaria.models.Cliente;

public class ClienteDTO {
    private String nome;
    private String email;

    public ClienteDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public ClienteDTO(Cliente cliente) {
        nome = cliente.getNome();
        email = cliente.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}