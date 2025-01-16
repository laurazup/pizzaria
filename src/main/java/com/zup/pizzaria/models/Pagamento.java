package com.zup.pizzaria.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private String formaPagamento;
    private Double valorPago;
    private Double troco;
    private Date dataHoraPagamento;

    public Pagamento(Long pedidoId) {
        this.pedidoId = pedidoId;
    }
}
