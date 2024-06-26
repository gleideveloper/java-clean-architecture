package br.com.alura.codechella.infrastructure.gateways;

import br.com.alura.codechella.application.gateways.UserRepository;
import br.com.alura.codechella.domain.entities.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceInFileImpl implements UserRepository {
    List<User> userList = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User changeEmailUser(String cpf, String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return this.userList;
    }

    public void recordDataFile(String fileName) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(userList.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Failed to close FileWriter: " + e.getMessage());
                }
            }
        }
    }
}
