package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.application.usercases.CreateUser;
import br.com.alura.codechella.application.usercases.ListUser;
import br.com.alura.codechella.application.usercases.RecordDataFile;
import br.com.alura.codechella.infrastructure.gateways.UserEntityMapper;
import br.com.alura.codechella.infrastructure.gateways.UserServiceInFileImpl;
import br.com.alura.codechella.infrastructure.gateways.UserServiceJPAImpl;
import br.com.alura.codechella.infrastructure.persistence.UserRepositoryJPA;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    CreateUser createUser(UserRepository userRepository){
        return new CreateUser(userRepository);
    }

    @Bean
    UserServiceJPAImpl userServiceImpl(UserRepositoryJPA userRepositoryJPA, UserEntityMapper userEntityMapper){
        return new UserServiceJPAImpl(userRepositoryJPA, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper(){
        return new UserEntityMapper();
    }

    @Bean
    ListUser listUser(UserRepository userRepository){
        return new ListUser(userRepository);
    }

    @Bean
    UserServiceInFileImpl userServiceInFile(){
        return new UserServiceInFileImpl();
    }

    @Bean
    public RecordDataFile recordDataFile(UserRepository userRepository) {
        return new RecordDataFile(userRepository);
    }

}
