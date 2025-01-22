package com.zup.pizzaria.dtos;

public class PedidoDTO {
    private String nomeCliente;
    private String emailCliente;
    private String descricaoPedido;
    private double totaldopedidoPedido;
    private long telefone;

    public PedidoDTO(String nomeCliente, String emailCliente, String descricaoPedido, double totaldopedidoPedido, long telefone) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.descricaoPedido = descricaoPedido;
        this.totaldopedidoPedido = totaldopedidoPedido;
        this.telefone = this.telefone;
    }

    public double getTotaldopedidoPedido() {
        return totaldopedidoPedido;
    }

    public void setTotaldopedidoPedido(double totaldopedidoPedido) {
        this.totaldopedidoPedido = totaldopedidoPedido;
    }

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

    public String getDescricaoPedido() {
        return descricaoPedido;
    }

    public void setDescricaoPedido(String descricaoPedido) {
        this.descricaoPedido = descricaoPedido;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}