package ru.rut.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.rut.up.dto.RegistrationDTO;
import ru.rut.up.exception.EntityNotFoundException;
import ru.rut.up.service.UserService;

@Controller
@RequestMapping("registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping
    public String getForm() {
        return "forms/registration";
    }

    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public String signUp(@ModelAttribute RegistrationDTO registrationDTO) {
        userService.registerNewUser(registrationDTO);
        throw new EntityNotFoundException("test");
        //return "forms/registration";
    }


    @RequestMapping(value = "/sign-in", method = RequestMethod.POST)
    public String signIn(@RequestBody RegistrationDTO registrationDTO) {
        return "forms/registration";
    }
}
