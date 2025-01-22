# Pizzaria

Este projeto é uma extensão do sistema de pedidos de uma pizzaria, onde foi implementada a funcionalidade de **Pagamentos**. A funcionalidade permite registrar pagamentos associados a pedidos, validando as informações fornecidas e garantindo que o valor pago seja suficiente para cobrir o valor total do pedido.

---

## **Descrição do Projeto**

O sistema foi projetado para gerenciar pagamentos de pedidos realizados na pizzaria. A implementação inclui:

1. **Classe `Pagamento`**:
    - Representa a entidade de pagamento no sistema.
    - Contém atributos essenciais para registrar um pagamento, como o identificador do pedido, forma de pagamento, valor pago e data/hora do pagamento.
    - Inclui validações para garantir a consistência dos dados.

2. **Diagrama UML**:
    - Representa a estrutura da classe `Pagamento`, detalhando seus atributos e métodos principais.

3. **Camadas do Sistema**:
    - **Model**: Representa a entidade `Pagamento` como uma classe JPA.
    - **Repository**: Interface para persistência de dados da entidade `Pagamento`.
    - **Service**: Contém a lógica de negócios, como validação do valor pago.
    - **Controller**: Exposição de endpoints REST para criar pagamentos.

---

## **Diagrama UML da Classe `Pagamento`**

O diagrama UML abaixo descreve a estrutura da classe `Pagamento`:

```plaintext
+-------------------+
| Pagamento         |
+-------------------+
| - id: Long        |
| - pedidoId: Long  |
| - formaPagamento: String |
| - valorPago: Double |
| - dataHoraPagamento: LocalDateTime |
+-------------------+
| + getId(): Long   |
| + setId(Long): void |
| + getPedidoId(): Long |
| + setPedidoId(Long): void |
| + getFormaPagamento(): String |
| + setFormaPagamento(String): void |
| + getValorPago(): Double |
| + setValorPago(Double): void |
| + getDataHoraPagamento(): LocalDateTime |
| + setDataHoraPagamento(LocalDateTime): void |
+-------------------+
Explicação do Diagrama UML
O diagrama UML acima representa a classe Pagamento com os seguintes elementos:

Atributos:

id: Identificador único do pagamento, gerado automaticamente.
pedidoId: Referência ao pedido que está sendo pago.
formaPagamento: Forma de pagamento utilizada (ex.: "CARTÃO", "DINHEIRO", "PIX").
valorPago: Valor pago pelo cliente.
dataHoraPagamento: Data e hora em que o pagamento foi realizado.
Métodos:

Métodos get e set para cada atributo, permitindo acesso e modificação dos valores.
Funcionalidades Implementadas
1. Classe Pagamento
A classe Pagamento foi implementada como uma entidade JPA, com os seguintes detalhes:

Anotação @Entity: Define a classe como uma entidade persistente.
Atributos:
id: Gerado automaticamente com a anotação @GeneratedValue.
pedidoId, formaPagamento, valorPago, dataHoraPagamento: Representam os dados do pagamento.
Validação:
O atributo valorPago possui uma validação para garantir que o valor não seja menor que o valor total do pedido.
2. Repository
A interface PagamentoRepository foi criada para gerenciar a persistência da entidade Pagamento. Ela estende JpaRepository, fornecendo métodos prontos para operações básicas de CRUD.

3. Service
A classe PagamentoService contém a lógica de negócios, incluindo:

Validação do valor pago:
Verifica se o valor pago é suficiente para cobrir o valor total do pedido.
Lança uma exceção caso o valor seja insuficiente.

4. Controller
A classe PagamentoController expõe um endpoint REST para criar pagamentos:

Endpoint POST /pagamentos:
Recebe os dados do pagamento no corpo da requisição.
Valida os dados e registra o pagamento no sistema.

Como Executar o Projeto
Pré-requisitos
Java 17
Spring Boot
Banco de dados configurado ( H2)
Passos para Execução

1.Clone o repositório:
git clone <https://github.com/laurazup/pizzaria.git>

2.Navegue até o diretório do projeto:
cd pizzaria

3.Execute o projeto:
./mvnw spring-boot:run

4.Acesse o endpoint de pagamentos:
POST /pagamentos: Registra um novo pagamento.

Exemplo de Requisição:
Endpoint: POST /pagamentos
Corpo da Requisição (JSON):

{
  "pedidoId": 1,
  "formaPagamento": "CARTÃO",
  "valorPago": 50.0,
  "dataHoraPagamento": "2023-10-10T15:30:00"
}

 Resposta (200 OK):

{
  "mensagem": "Pagamento realizado com sucesso!"
}

Validações Implementadas.

Valor Pago:
O valor pago não pode ser menor que o valor total do pedido.
Caso contrário, uma exceção será lançada com a mensagem: "O valor pago não pode ser menor que o valor total do pedido."
Pedido Existente:

O sistema verifica se o pedido associado ao pagamento existe no banco de dados.

Estrutura do Projeto:

src/
├── main/
│   ├── java/com/zup/pizzaria/
│   │   ├── controllers/
│   │   │   └── PagamentoController.java
│   │   ├── dtos/
│   │   │   └── PedidoDTO.java
│   │   ├── models/
│   │   │   ├── Cliente.java
│   │   │   ├── Pedido.java
│   │   │   └── Pagamento.java
│   │   ├── repository/
│   │   │   ├── ClienteRepository.java
│   │   │   ├── PedidoRepository.java
│   │   │   └── PagamentoRepository.java
│   │   ├── services/
│   │   │   └── PagamentoService.java
│   │   └── PizzariaApplication.java
├── resources/
│   ├── application.properties

Tecnologias Utilizadas:
Java 17
Spring Boot
H2 Database (pode ser substituído por outro banco de dados)
Maven

