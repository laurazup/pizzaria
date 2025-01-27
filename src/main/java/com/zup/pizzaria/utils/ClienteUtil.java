package com.zup.pizzaria.utils;

public class ClienteUtil {
    public static void clienteUtil(String nome, String email, String telefone) {

        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

        String emailCliente = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        if (email == null || !email.matches(emailCliente)) {
            throw new IllegalArgumentException("O e-mail fornecido é inválido.");
        }
        String telefoneCliente = "^[0-9]{8,}$";
        if (telefone == null || !telefone.matches(telefoneCliente)) {
            throw new IllegalArgumentException("O telefone deve conter apenas números e ter no mínimo 8 dígitos.");
        }
    }
    public static void main(String[] args) {
        try {
            // Exemplo de uso
            clienteUtil("João Silva", "joao.silva@email.com", "12345678");
            System.out.println("Todos os dados são válidos!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
