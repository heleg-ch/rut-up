package ru.rut.up.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping("/sign-up")
    public String registrationForm() {
        return "forms/registration";
    }

}
