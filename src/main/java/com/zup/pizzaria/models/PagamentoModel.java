package com.zup.pizzaria.models;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


@Entity
public class PagamentoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O ID do pedido é obrigatorio")
    private Long pedidoId;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = " A forma de pagamento é obrigatorio")
    private FormaPagamento formaPagamento;

    @NotNull(message = "O valor pago é obrigatorio")
    @Min(value = 0, message = "O valor pago não pode ser menor que zero.")
    private Double valorPago;

    @NotNull(message = "A data e hora do pagamento são obrigatorias")
    private LocalDateTime dataHoraPagamento;


    public PagamentoModel() {
    }

    public PagamentoModel(Long pedidoId, String FormaPagamento, Double valorPago, LocalDateTime dataHoraPagamento) {
        this.pedidoId = pedidoId;
        this.formaPagamento = formaPagamento;
        this.valorPago = valorPago;
        this.dataHoraPagamento = dataHoraPagamento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento( FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDateTime getDataHoraPagamento() {
        return dataHoraPagamento;
    }

    public void setDataHoraPagamento(LocalDateTime dataHoraPagamento) {
        this.dataHoraPagamento = dataHoraPagamento;
    }


}
