package br.com.alura.codechella.infrastructure.gateways;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infrastructure.persistence.UserEntity;

public class UserEntityMapper {
    public UserEntity toEntity(User user){
        return new UserEntity(
                user.getCpf(),
                user.getName(),
                user.getBirthDate(),
                user.getEmail()
        );
    }

    public User toDomainUser(UserEntity userEntity){
        return new User(
                userEntity.getName(),
                userEntity.getCpf(),
                userEntity.getBirthDate(),
                userEntity.getEmail(),
                null
        );
    }
}
