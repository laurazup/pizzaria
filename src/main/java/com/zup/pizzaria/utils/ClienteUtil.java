package com.zup.pizzaria.utils;

import com.zup.pizzaria.dtos.ClienteDTO;

public class ClienteUtil {
    public static void validarCliente(ClienteDTO clienteDTO) {

        if (clienteDTO.getNomeCliente() == null || clienteDTO.getNomeCliente().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio ou nulo.");
        }

        String emailRegex = "^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$";
        if (clienteDTO.getEmailCliente() == null || !clienteDTO.getEmailCliente().matches(emailRegex)) {
            throw new IllegalArgumentException("O e-mail fornecido é inválido.");
        }

        String telefoneRegex = "^[0-9]{8,}$";
        if (clienteDTO.getTelefoneCliente() == null || !clienteDTO.getTelefoneCliente().matches(telefoneRegex)) {
            throw new IllegalArgumentException("O telefone deve conter apenas números e ter no mínimo 8 dígitos.");
        }
    }

    public static void main(String[] args) {

    }

    public static void validarCliente(String joãoSilva, String mail, String number) {
    }
}
