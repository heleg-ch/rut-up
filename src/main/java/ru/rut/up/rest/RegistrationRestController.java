package ru.rut.up.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rut.up.dto.BooleanDTO;
import ru.rut.up.dto.LoginDTO;
import ru.rut.up.service.UserService;

@RestController
@RequestMapping("api/registration/")
public class RegistrationRestController {

    private final UserService userService;

    public RegistrationRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("login")
    public ResponseEntity<BooleanDTO> checkEmail(@Validated @RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(userService.firstStepRegistration(loginDTO.getLogin()), HttpStatus.OK);
    }
}