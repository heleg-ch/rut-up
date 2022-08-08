package ru.home.preparado.service;

import org.springframework.stereotype.Service;
import ru.home.preparado.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existByLogin(String login) {
        return userRepository.existsByLogin(login);
    }
}