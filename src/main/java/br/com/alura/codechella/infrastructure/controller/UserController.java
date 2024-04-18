package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usercases.CreateUser;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.zcodedraft.model.Usuario;
import br.com.alura.codechella.zcodedraft.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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
