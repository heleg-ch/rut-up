package ru.home.preparado.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.preparado.dto.BooleanDTO;
import ru.home.preparado.dto.LoginDTO;
import ru.home.preparado.service.UserService;

@RestController
@RequestMapping("api/")
public class RegistrationRestController {

    private final UserService userService;

    public RegistrationRestController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("check-login")
    public ResponseEntity<BooleanDTO> checkEmail(@Validated @RequestBody LoginDTO loginDTO) {
        return new ResponseEntity<>(userService.existByLogin(loginDTO.getLogin()), HttpStatus.OK);
    }
}