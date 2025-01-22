
package com.zup.pizzaria.dtos;

import java.time.LocalDateTime;

public class PagamentoDTO {
    private long idPagamento;
    private long pedidoidPagamento;
    private String formaPagamentoPagamento;
    private double valorPagoPagamento;
    private int escolha;
    LocalDateTime dataHoraPagamento; // Data e hora do pagamento


    public PagamentoDTO(String formaPagamentoPagamento, LocalDateTime dataHoraPagamento, long id, int escolha, double valorPago, double totaldopedidoPedido, long pedidoid) {
        this.formaPagamentoPagamento = formaPagamentoPagamento;
        this.idPagamento = idPagamento;
        this.pedidoidPagamento = pedidoidPagamento;
        this.valorPagoPagamento = valorPagoPagamento;
        this.escolha = this.escolha;
        this.dataHoraPagamento = this.dataHoraPagamento;
    }

    public String getFormaPagamentoPagamento() {
        return formaPagamentoPagamento;
    }

    public void setFormaPagamentoPagamento(String formaPagamentoPagamento) {
        this.formaPagamentoPagamento = formaPagamentoPagamento;
    }

    public long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(long idPagamento) {
        this.idPagamento = idPagamento;
    }

    public long getPedidoidPagamento() {
        return pedidoidPagamento;
    }

    public void setPedidoidPagamento(long pedidoidPagamento) {
        this.pedidoidPagamento = pedidoidPagamento;
    }

    public double getValorPagoPagamento() {
        return valorPagoPagamento;
    }

    public void setValorPagoPagamento(double valorPagoPagamento) {
        this.valorPagoPagamento = valorPagoPagamento;
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
}