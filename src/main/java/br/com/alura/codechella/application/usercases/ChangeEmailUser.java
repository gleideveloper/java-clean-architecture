package br.com.alura.codechella.application.usercases;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

public class ChangeEmailUser {
    private final UserRepository userRepository;

    public ChangeEmailUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User changeEmailUser(User user) {
        return userRepository.changeEmailUser(user.getCpf(), user.getEmail());
    }

}
