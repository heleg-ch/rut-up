package ru.rut.up.dto;

import javax.validation.constraints.NotEmpty;

public class LoginDTO {

    @NotEmpty
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "login='" + login + '\'' +
                '}';
    }
}
