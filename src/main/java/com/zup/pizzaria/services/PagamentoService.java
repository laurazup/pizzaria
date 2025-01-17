package com.zup.pizzaria.services;

import com.zup.pizzaria.models.PagamentoModel;
import com.zup.pizzaria.models.Pedido;
import com.zup.pizzaria.repository.PedidoRepository;

public class PagamentoService {

    private final PedidoRepository pedidoRepository;

    public PagamentoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void validarPagamento(PagamentoModel pagamento) {
        Pedido pedido = pedidoRepository.findById(pagamento.getPedidoId())
                .orElseThrow(() -> new IllegalArgumentException("Pedido não encontrado"));

        // Exemplo de validação: valorPago não pode ser menor que o valor total do pedido
        if (pagamento.getValorPago() < pedido.getDescricao().length()) { // Substitua por lógica real
            throw new IllegalArgumentException("O valor pago não pode ser menor que o valor total do pedido.");
        }
    }

}
