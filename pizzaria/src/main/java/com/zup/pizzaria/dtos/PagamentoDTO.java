package com.zup.pizzaria.dtos;

import java.time.LocalDateTime;

import com.zup.pizzaria.dtos.PedidoDTO;

public class PagamentoDTO {
    private long id;
    private long pedidoId;
    private String formaPagamento;
    private double valorPago;
    private int escolha;
    LocalDateTime dataHoraPagamento;
    private double totadopedido;

    public PagamentoDTO(LocalDateTime dataHoraPagamento, int escolha, String formaPagamento, long id, long pedidoId, double valorPago, double totadopedido) {
        this.dataHoraPagamento = dataHoraPagamento;
        this.escolha = escolha;
        this.formaPagamento = formaPagamento;
        this.id = id;
        this.pedidoId = pedidoId;
        this.valorPago = valorPago;
        this.totadopedido = totadopedido;
    }

    public PagamentoDTO(double totadopedido, String descricaoPedido, LocalDateTime dataHoraPagamento, long id, long pedidoId, int escolha, String formaPagamento, double valorPago) {
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public int getEscolha() {
        return escolha;
    }

    public void setEscolha(int escolha) {
        this.escolha = escolha;
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

    public long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getTotadopedido() {
        return totadopedido;
    }

    public void setTotadopedido(double totadopedido) {
        this.totadopedido = totadopedido;
    }
}
