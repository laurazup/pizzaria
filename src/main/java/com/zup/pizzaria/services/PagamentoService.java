package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.repository.PedidoRepository;

public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }


    public void processarPagamento(Pedido pedido, String formaPagamento, Double valorPago) {
        System.out.println("Processando pagamento na forma de " + formaPagamento);

        if (valorPago >= pedido.getValorTotal()) {
            Pagamento newPagamento = new Pagamento(pedido.getId(), formaPagamento, valorPago);
            newPagamento.setTroco(valorPago - pedido.getValorTotal());

            pagamentoRepository.save(newPagamento);

            System.out.println("Pagamento realizado com sucesso!\n" +
                    "Seu troco é de: " + newPagamento.getTroco());
        } else {
            System.err.println("O valor pago de " + valorPago
                    + "é menor que " + pedido.getValorTotal()
                    + "referente ao valor total do pedido!"
            );
        }
    }
}
