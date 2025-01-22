package com.zup.pizzaria.dtos;

public class ClienteDTO {
    private String nomeCliente;
    private String emailCliente;
    private long telefone;

    public ClienteDTO(String emailCliente, String nomeCliente, long telefone) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.telefone = telefone;
    }
    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
