# Pizzaria

Este projeto é uma extensão do sistema de pedidos de uma pizzaria, onde foi implementada a funcionalidade de *
*Pagamentos**. A funcionalidade permite registrar pagamentos associados a pedidos, validando as informações fornecidas e
garantindo que o valor pago seja suficiente para cobrir o valor total do pedido.

---

## **Descrição do Projeto**

O sistema foi projetado para gerir pagamentos de pedidos realizados na pizzaria. A implementação inclui:

 1. **Classe `Pagamento`**:
    - Representa a entidade de pagamento no sistema.
    - Contém atributos essenciais para registrar um pagamento, como o identificador do pedido, forma de pagamento, valor
      pago e data/hora do pagamento.
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

  # ALTERAÇÕES RECENTES :

 1. Refatoração da ClienteController
Alterado para utilizar a classe ClienteService ao invés de acessar diretamente o ClienteRepository.
Adicionado endpoint PUT para atualizar um cliente.

 2. Criação das classes de serviço
Criadas para encapsular a lógica de negócios relacionada às entidades:
ClienteService: Gerencia operações relacionadas a clientes.
PedidoService: Gerencia operações relacionadas a pedidos.
PagamentoService: Gerencia operações relacionadas a pagamentos.

 3. Criação da pasta exceptions
Adicionada a classe GlobalExceptionHandler para tratar exceções de forma centralizada.
Exceções tratadas:
IllegalArgumentException: Retorna status 400 Bad Request com a mensagem de erro.
NoSuchElementException: Retorna status 404 Not Found com a mensagem de erro.
Outras exceções genéricas retornam status 500 Internal Server Error.

 4.Diagrama UML
O diagrama UML abaixo representa a estrutura do projeto, destacando as relações entre as classes principais:
+---------------------+
|     Cliente         |
+---------------------+
| - id: Long          |
| - nome: String      |
| - email: String     |
+---------------------+
          |
          v
+---------------------+
|  ClienteRepository  |
+---------------------+
| + save(cliente)     |
| + findById(id)      |
| + deleteById(id)    |
+---------------------+
          ^
          |
+---------------------+
|   ClienteService    |
+---------------------+
| + criarCliente()    |
| + buscarClientePorId|
| + atualizarCliente  |
| + deletarCliente    |
+---------------------+
          ^
          |
+---------------------+
|  ClienteController  |
+---------------------+
| + POST /clientes    |
| + GET /clientes/{id}|
| + PUT /clientes/{id}|
| + DELETE /clientes/{id}|
+---------------------+
Descrição do Diagrama:
*Cliente: Representa a entidade principal com atributos id, nome e email.
*ClienteRepository: Interface responsável pela interação com o banco de dados.
*ClienteService: Camada de serviço que encapsula a lógica de negócios.
*ClienteController: Controlador que expõe os endpoints da API.
*GlobalExceptionHandler (não representado no diagrama): Classe para tratamento centralizado de exceções.

 5.Endpoints Disponíveis:
ClienteController
POST /clientes: Cria um novo cliente.
GET /clientes/{id}: Busca um cliente pelo ID.
PUT /clientes/{id}: Atualiza os dados de um cliente existente.
DELETE /clientes/{id}: Remove um cliente pelo ID.
PedidoController
POST /pedidos: Cria um novo pedido.
GET /pedidos/{id}: Busca um pedido pelo ID.
PUT /pedidos/{id}: Atualiza os dados de um pedido existente.
DELETE /pedidos/{id}: Remove um pedido pelo ID.
PagamentoController
POST /pagamentos: Cria um novo pagamento.
GET /pagamentos/{id}: Busca um pagamento pelo ID.
PUT /pagamentos/{id}: Atualiza os dados de um pagamento existente.
DELETE /pagamentos/{id}: Remove um pagamento pelo ID.

 Exemplo de Uso:
Requisição para criar um cliente

POST /clientes
Content-Type: application/json
{
  "nome": "João Silva",
  "email": "joao.silva@email.com"
}

Resposta
HTTP/1.1 201 Created
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com"
}

 Tratamento de Erros:
Exemplo de erro ao criar um cliente com e-mail duplicado
POST /clientes
Content-Type: application/json
{
  "nome": "Maria Oliveira",
  "email": "joao.silva@email.com"
}

Resposta
HTTP/1.1 400 Bad Request
{
  "error": "Já existe um cliente com este e-mail."
}

 Estrutura do Projeto:
src/
├── main/
│   ├── java/
│   │   ├── com.zup.pizzaria/
│   │   │   ├── controllers/
│   │   │   │   ├── ClienteController.java
│   │   │   │   ├── PagamentoController.java
│   │   │   │   └── PedidoController.java
│   │   │   ├── dtos/
│   │   │   │   └── PedidoDTO.java
│   │   │   ├── exceptions/
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   ├── models/
│   │   │   │   ├── Cliente.java
│   │   │   │   ├── PagamentoModel.java
│   │   │   │   ├── Pedido.java
│   │   │   │   └── FormaPagamento.java (enum)
│   │   │   ├── repository/
│   │   │   │   ├── ClienteRepository.java
│   │   │   │   ├── PagamentoRepository.java
│   │   │   │   └── PedidoRepository.java
│   │   │   ├── services/
│   │   │   │   ├── ClienteService.java
│   │   │   │   ├── PagamentoService.java
│   │   │   │   └── PedidoService.java
│   ├── resources/
│   │   └── application.properties



Como Executar o Projeto
Pré-requisitos
Java 17
Spring Boot
Banco de dados configurado (H2)

Passos para Execução:

1.Clone o repositório: git clone <https://github.com/laurazup/pizzaria.git>

2.Navegue até o diretório do projeto:
cd pizzaria-api

3.Configure o banco de dados no arquivo application.properties.

4.Execute o projeto:
./mvnw spring-boot:run

5.Acesse o endpoint de pagamentos:
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

Tecnologias Utilizadas:
Java 17
Spring Boot
H2 Database (pode ser substituído por outro banco de dados)
Maven

