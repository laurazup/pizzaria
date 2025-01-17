package com.zup.pizzaria.services;
import com.zup.pizzaria.dtos.PagamentoDTO;
import com.zup.pizzaria.dtos.PedidoDTO;
import com.zup.pizzaria.models.Pagamento;
import com.zup.pizzaria.repository.PedidoRepository;
import com.zup.pizzaria.repository.PagamentoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Scanner;

@Service
public class PagamentoService {
    private final PedidoRepository pedidoRepository;
    private final PagamentoRepository pagamentoRepository;
    private final PedidoDTO pedidoDTO;


    public PagamentoService(PedidoRepository pedidoRepository, PagamentoRepository pagamentoRepository, PedidoDTO pedidoDTO) {
        this.pedidoRepository = pedidoRepository;
        this.pagamentoRepository = pagamentoRepository;
        this.pedidoDTO =  pedidoDTO;
    }
    public  PagamentoDTO fazerpagamento(Pagamento pagamento,PedidoDTO pedidoDTO){
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Qual será a forma de pagamento? Digite 1 para Pix, 2 para Cartão e 3 para pagar em dinheiro");
            pagamento.setEscolha(scanner.nextInt());
            switch (pagamento.getEscolha()) {
                case 1:
                    pagamento.setFormaPagamento("Pix");
                    break;
                case 2:
                    pagamento.setFormaPagamento("Cartão");
                    break;
                case 3:
                    pagamento.setFormaPagamento("dinheiro");
                    System.out.println("Você tera de pagar quando o motoboy chegar em sua residencia, o total ficou em :" + pedidoDTO.getTotadopedido());
                    break;
                default:
                    System.out.println("Oção de pagamento invalida ");
                    break;
            }
            if (pagamento.getFormaPagamento() == "Pix" || pagamento.getFormaPagamento() == "Cartão") {
                System.out.println("Pague aqui para para receber a pizza: ");
                System.out.println("Voce tem que pagar: " + pedidoDTO.getTotadopedido());
                System.out.println("Pague agora:");
                pagamento.setValorPago(scanner.nextDouble());
            }
        } while ((pedidoDTO.getTotadopedido() > pagamento.getValorPago() )|| pagamento.getFormaPagamento() == null);
        pagamento.setDataHoraPagamento( LocalDateTime.now());
        return null;// new PagamentoDTO(PedidoDTO.getTotadopedido, pagamento.getEscolha(), pagamento.getPedidoId(), pagamento.getId(), pagamento.getFormaPagamento(),pagamento.getValorPago,pagamento.getdataHoraPagamento);
    }
}