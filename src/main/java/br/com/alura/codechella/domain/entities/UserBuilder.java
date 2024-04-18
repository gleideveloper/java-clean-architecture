package br.com.alura.codechella.domain.entities;

import java.time.LocalDate;

public interface UserBuilder {
    UserBuilderImpl.Builder withNameCpfBirthDate(String name, String cpf, LocalDate birthDate);
    UserBuilderImpl.Builder includeAddress(String zidCode, Integer number, String complement );
}
