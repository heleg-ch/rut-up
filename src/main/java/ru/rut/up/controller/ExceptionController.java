package ru.rut.up.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.rut.up.exception.EntityNotFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    public String entityNotFoundException(EntityNotFoundException e) {
        return "error";
    }
}
