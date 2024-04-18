package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class UserBuilderImpl {
    private final String name;
    private final String cpf;
    private final LocalDate birthDate;
    private final String email;
    private final Address address;

    public UserBuilderImpl(Builder userBuilder) {
        this.name = userBuilder.name;
        this.cpf = userBuilder.cpf;
        this.birthDate = userBuilder.birthDate;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
    }

    public static class Builder implements UserBuilder {
        private String name;
        private String cpf;
        private LocalDate birthDate;
        private String email;
        private Address address;

        @Override
        public Builder withNameCpfBirthDate(String name, String cpf, LocalDate birthDate) {
            this.name = name;
            this.cpf = cpf;
            this.birthDate = birthDate;
            return this;
        }

        @Override
        public Builder includeAddress(String zipCode, Integer number, String complement) {
            this.address = new Address(zipCode, number, complement);
            return this;
        }

        public UserBuilderImpl build() {
            return new UserBuilderImpl(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
