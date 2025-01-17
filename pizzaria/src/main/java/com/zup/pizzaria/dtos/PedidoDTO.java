package com.zup.pizzaria.dtos;

public class PedidoDTO {
    private String nomeCliente;
    private String emailCliente;
    private String descricaoPedido;
    private double totadopedido;

    public PedidoDTO(String nomeCliente, String emailCliente, String descricaoPedido,double totadopedido) {
        this.nomeCliente = nomeCliente;
        this.emailCliente = emailCliente;
        this.descricaoPedido = descricaoPedido;
        this.totadopedido = totadopedido;
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

    public double getTotadopedido() {
        return totadopedido;
    }

    public void setTotadopedido(double totadopedido) {
        this.totadopedido = totadopedido;
    }
}
