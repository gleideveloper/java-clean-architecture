package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;

public class User {
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private Address address;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.cpf = userBuilder.cpf;
        this.birthDate = userBuilder.birthDate;
        this.email = userBuilder.email;
        this.address = userBuilder.address;
    }

    public static class UserBuilder {
        private String name;
        private String cpf;
        private LocalDate birthDate;
        private String email;
        private Address address;

        public UserBuilder withNameCpfBirthDate(String name, String cpf, LocalDate birthDate) {
            this.name = name;
            this.cpf = cpf;
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder includeAddress(String zipCode, Integer number, String complement) {
            this.address = new Address(zipCode, number, complement);
            return this;
        }

        public User build() {
            return new User(this);
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
