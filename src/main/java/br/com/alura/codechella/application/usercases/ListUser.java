package br.com.alura.codechella.application.usercases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public class ListUser {
    private final UserRepository userRepository;

    public ListUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return this.userRepository.getAll();
    }
}
