package ru.rut.up.exception;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(String entityName) {
        super(String.format("Entity by name: %s not exist", entityName));
    }
}
