package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Address;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;
    private String cpf;
    private LocalDate birthDate;
    private String email;
    private Address address;

    public User(String name, String cpf, LocalDate birthDate, String email, Address address) {
        if (cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            throw new IllegalArgumentException("CPF no padrão incorreto!");
        }
        // Calcula a idade com base na data de nascimento e a data atual
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        // Verifica se a idade é inferior a 18 anos e lança uma exceção se for
        if (age < 18) {
            throw new IllegalArgumentException("Usuário deve ter pelo menos 18 anos de idade!");
        }

        this.name = name;
        this.cpf = cpf;
        this.birthDate = birthDate;
        this.email = email;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
