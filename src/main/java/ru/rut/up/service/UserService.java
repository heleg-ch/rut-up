package ru.rut.up.service;

import org.springframework.stereotype.Service;
import ru.rut.up.dto.BooleanDTO;
import ru.rut.up.dto.RegistrationDTO;
import ru.rut.up.exception.EntityNotFoundException;
import ru.rut.up.model.User;
import ru.rut.up.repository.UserRepository;
import ru.rut.up.util.RandomGeneratorUtil;

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

    public void registerNewUser(RegistrationDTO registrationDTO) {
        User user = userRepository.findByLogin(registrationDTO.getLogin());
        if (user.getActivationKey().isEmpty()) {
            throw new EntityNotFoundException("activation key");
        }
        if (!user.getActivationKey().equals(registrationDTO.getPassword())) {
            throw new RuntimeException("");
        }
        user.setPassword(registrationDTO.getPassword());
        user.setActivationKey(null);
        userRepository.save(user);
    }
}