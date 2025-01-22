package com.zup.pizzaria.dtos;

public class ClienteDTO {

    private String nomeCliente;
    private String emailCliente;
    private Long telefoneCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Long getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(Long telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }
}

