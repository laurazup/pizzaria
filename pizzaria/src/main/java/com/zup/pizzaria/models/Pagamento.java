package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long pedidoid;
    private String formaPagamento;
    private double valorPago;
    private int escolha;
    LocalDateTime dataHoraPagamento; // Data e hora do pagamento


    public Pagamento(String formaPagamento, long id, long pedidoid, double valorPago, int escolha,LocalDateTime dataHoraPagamento) {
        this.formaPagamento = formaPagamento;
        this.id = id;
        this.pedidoid = pedidoid;
        this.valorPago = valorPago;
        this.escolha = escolha;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(long pedidoid) {
        this.pedidoid = pedidoid;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }
}
