package ru.home.preparado.service;

import org.springframework.stereotype.Service;
import ru.home.preparado.dto.BooleanDTO;
import ru.home.preparado.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public BooleanDTO existByLogin(String login) {
        return new BooleanDTO(userRepository.existsByLogin(login));
    }
}