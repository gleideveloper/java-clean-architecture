package br.com.alura.codechella.config;

import br.com.alura.codechella.infrastructure.gateways.UserServiceInFileImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("use-file")
public class UserConfigFile {
    @Bean
    UserServiceInFileImpl userServiceInFile(){
        return new UserServiceInFileImpl();
    }
}
