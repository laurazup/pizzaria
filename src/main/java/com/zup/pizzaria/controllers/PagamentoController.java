package com.zup.pizzaria.controllers;

import com.zup.pizzaria.models.PagamentoModel;
import com.zup.pizzaria.services.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity<String> criarPagamento(@RequestBody PagamentoModel pagamento) {
        pagamentoService.validarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento realizado com sucesso!");
    }

}
