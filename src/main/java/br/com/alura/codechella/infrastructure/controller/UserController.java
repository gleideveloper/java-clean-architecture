package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usercases.CreateUser;
import br.com.alura.codechella.domain.entities.user.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser) {
        this.createUser = createUser;
    }

    @PostMapping
    public ResponseEntity<User> cadastrar(@RequestBody @Valid UserDTO userDTO) {
        var user = createUser.SaveUser(new User(userDTO.name(), userDTO.cpf(), userDTO.birthDate(), userDTO.email(), null));
        return ResponseEntity.ok().body(user);
    }

}
