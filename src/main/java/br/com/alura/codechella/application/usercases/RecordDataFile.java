package br.com.alura.codechella.application.usercases;

import br.com.alura.codechella.application.gateways.UserRepository;

public class RecordDataFile {
    private final UserRepository userRepository;

    public RecordDataFile(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void Record(String fileName) {
        userRepository.recordDataFile(fileName);
    }
}
