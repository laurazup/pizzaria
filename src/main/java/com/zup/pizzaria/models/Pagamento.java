package com.zup.pizzaria.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String formaPagamento;

    @Column(nullable = false)
    private double valorPago;

    @Column(nullable = false)
    private LocalDateTime dataHoraPagamento;


    // Construtor com validação
    public Pagamento(Long pedidoId, String formaPagamento, double valorPago, double valorTotalPedido) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = LocalDateTime.now(); // Data e hora do pagamento gerada automaticamente

        // Validação: valorPago não pode ser menor que o valor total do pedido
        if (valorPago < valorTotalPedido) {
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
    }

    public Pagamento() {
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }
    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", pedidoId=" + pedidoId +
                ", formaPagamento='" + formaPagamento + '\'' +
                ", valorPago=" + valorPago +
                ", dataHoraPagamento=" + dataHoraPagamento +
                '}';
    }
}
