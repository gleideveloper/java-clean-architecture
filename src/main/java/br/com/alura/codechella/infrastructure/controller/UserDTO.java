package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public record UserDTO(
        String name,
        String cpf,
        LocalDate birthDate,
        String email
) {}
