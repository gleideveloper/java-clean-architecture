package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usercases.CreateUser;
import br.com.alura.codechella.application.usercases.ListUser;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infrastructure.gateways.UserServiceInFileImpl;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

//    private final CreateUser createUser;
//    private final ListUser listUser;

    private final UserServiceInFileImpl userServiceInFile;

    public UserController(UserServiceInFileImpl userServiceInFile) {
        this.userServiceInFile = userServiceInFile;
    }

//    public UserController(CreateUser createUser, ListUser listUser) {
//        this.createUser = createUser;
//        this.listUser = listUser;
//    }

    @PostMapping
    public ResponseEntity<User> cadastrar(@RequestBody @Valid UserDTO userDTO) {
        var user = userServiceInFile.saveUser(new User(userDTO.name(), userDTO.cpf(), userDTO.birthDate(), userDTO.email(), null));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok().body(userServiceInFile.getAll());
    }
}
