package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Long clienteId;
    private double totadopedido;

    public Pedido(Long clienteId, String descricao,double totaldopedido) {
        this.clienteId = clienteId;
        this.descricao = descricao;
        this.totadopedido = totaldopedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public double getTotadopedido() {
        return totadopedido;
    }

    public void setTotadopedido(double totadopedido) {
        this.totadopedido = totadopedido;
    }
}
