package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.entities.user.UserEntity;

import java.time.LocalDate;

public interface Builder {
    void withNameCpfBirthDate(String name, String cpf, LocalDate birthDate);
    void includeAddress(String zidCode, Integer number, String complement );
}
