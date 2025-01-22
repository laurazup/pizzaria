package com.zup.pizzaria.services;

import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.repository.PagamentoRepository;
import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.dtos.ClienteDTO;

public class PagamentoService {
    private PagamentoRepository pagamentoRepository;
    private PedidoDTO pedidoDTO;
    private

     PagamentoService(PagamentoRepository pagamentoRepository, PedidoDTO pedidoDTO) {
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoDTO = pedidoDTO;
    }
/*
    public validarpagamentos(Pagamento pagamento, PedidoDTO pedidoDTO) {
        // Salva pagamento
        pagamentoRepository.save(pagamento);
        do {
            System.out.println("Qual será a forma de pagamento? Digite 1 para Pix, 2 para Cartão e 3 para pagar em dinheiro");
            switch (pagamento.getEscolha()) {
                case 1:
                    pagamento.setFormaPagamento("Pix");
                    break;
                case 2:
                    pagamento.setFormaPagamento("Cartão");
                case 3:
                    pagamento.setFormaPagamento("dinheiro");
                    System.out.println("Você tera de pagar quando o motoboy chegar em sua residencia, o total ficou em :" + pedidoDTO.getTotaldopedidoPedido());
                    break;
                default:
                    System.out.println("Oção de pagamento invalida ");
                    break;
            }
            if ((pagamento.getFormaPagamento() == "Pix") || (pagamento.getFormaPagamento() == "Cartão")) {
                System.out.println("Pague aqui para para receber a pizza: ");
                System.out.println("Voce tem que pagar: " + pedidoDTO.getTotaldopedidoPedido());
                System.out.println("Pague agora:");
            }
        } while (pedidoDTO.getTotaldopedidoPedido() > pagamento.getValorPago() || pagamento.getFormaPagamento() == null);

        return new PagamentoDTO(pagamento.getFormaPagamento(), pagamento.getDataHoraPagamento(), pagamento.getId(), pagamento.getEscolha(), pagamento.getValorPago(), pedidoDTO.getTotaldopedidoPedido(), pagamento.getPedidoid());
    }
*/
}
