package br.com.alura.codechella.infrastructure.gateways;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infrastructure.persistence.UserRepositoryJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final UserEntityMapper mapper;

    public UserServiceImpl(UserRepositoryJPA userRepositoryJPA, UserEntityMapper mapper) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.mapper = mapper;
    }

    @Override
    public User saveUser(User user) {
        var userEntity = mapper.toEntity(user);
        userRepositoryJPA.save(userEntity);
        return mapper.toDomainUser(userEntity);
    }

    @Override
    public User changeEmailUser(String cpf, String email) {
        var userEntity = userRepositoryJPA.findByCpf(cpf);
        userEntity.setEmail(email);
        userRepositoryJPA.save(userEntity);
        return mapper.toDomainUser(userEntity);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoryJPA.findAll().stream()
                .map(mapper::toDomainUser)
                .collect(Collectors.toList());
    }
}
