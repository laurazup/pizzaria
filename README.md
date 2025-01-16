# pizzaria

```mermaid

classDiagram
class Pagamento
    Pagamento: -Long id
    Pagamento: -Long pedidoId
    Pagamento: -String formaPagamento
    Pagamento: -Double valorPago
    Pagamento: -Double troco
    Pagamento: -LocalDateTime dataHoraPagamento
    
    Pagamento: +Pagamento(Long pedidoId)
    Pagamento: +getTroco() Double
    Pagamento: +setTroco(Double troco) void
```