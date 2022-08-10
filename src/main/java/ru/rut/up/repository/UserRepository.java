package ru.rut.up.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.rut.up.exception.EntityNotFoundException;
import ru.rut.up.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    default User findByLogin(String login) {
        return getByLogin(login).orElseThrow(
                () -> new EntityNotFoundException(login));
    }

    boolean existsByLogin(String login);
    Optional<User> getByLogin(String login);
}
