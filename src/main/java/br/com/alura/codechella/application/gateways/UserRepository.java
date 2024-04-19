package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public interface UserRepository {

    User saveUser(User user);

    User changeEmailUser(String cpf, String email);

    List<User> getAll();

}
