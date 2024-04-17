package br.com.alura.codechella.domain.entities;

import br.com.alura.codechella.domain.Address;
import br.com.alura.codechella.domain.entities.user.UserEntity;

import java.time.LocalDate;
/**
 * User: Não é o Padrão Factory e sim o Padrão Builder.
 */
public class User{
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

    public static class UserBuilder{
        private String name;
        private String cpf;
        private LocalDate birthDate;
        private String email;
        private Address address;

        public void withNameCpfBirthDate (String name, String cpf, LocalDate birthDate){
            this.name = name;
            this.cpf = cpf;
            this.birthDate = birthDate;
        }

        public void includeAddress (String zidCode, Integer number, String complement){
            this.address = new Address(zidCode, number, complement);
        }

        public User build () {
            return new User(this);
        }
    }
}
