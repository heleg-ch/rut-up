package ru.home.preparado.service;

import org.springframework.stereotype.Service;
import ru.home.preparado.dto.BooleanDTO;
import ru.home.preparado.model.User;
import ru.home.preparado.repository.UserRepository;
import ru.home.preparado.util.RandomGeneratorUtil;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MailService mailService;

    public UserService(UserRepository userRepository, MailService mailService) {
        this.userRepository = userRepository;
        this.mailService = mailService;
    }

    public BooleanDTO firstStepRegistration(String login) {
        boolean userExist = userRepository.existsByLogin(login);
        if (!userExist) {
            User newUser = new User();
            newUser.setLogin(login);
            final String code = RandomGeneratorUtil.getCode();
            newUser.setActivationKey(code);
            userRepository.save(newUser);
            mailService.sendMessage(login, code);

        }
        return new BooleanDTO(userExist);
    }
}