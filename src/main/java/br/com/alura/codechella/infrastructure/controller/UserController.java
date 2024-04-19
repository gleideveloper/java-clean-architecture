package br.com.alura.codechella.infrastructure.controller;

import br.com.alura.codechella.application.usercases.CreateUser;
import br.com.alura.codechella.application.usercases.ListUser;
import br.com.alura.codechella.application.usercases.RecordDataFile;
import br.com.alura.codechella.domain.entities.user.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final CreateUser createUser;
    private final ListUser listUser;
//    private final RecordDataFile recordDataFile;

    public UserController(CreateUser createUser, ListUser listUser) {
        this.createUser = createUser;
        this.listUser = listUser;
//        this.recordDataFile = recordDataFile;
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid UserDTO userDTO) {
        var user = createUser.saveUser(new User(userDTO.name(), userDTO.cpf(), userDTO.birthDate(), userDTO.email(), null));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
//        this.recordDataFile.Record("fileName.txt");
        return ResponseEntity.ok().body(listUser.getAll());
    }
}
