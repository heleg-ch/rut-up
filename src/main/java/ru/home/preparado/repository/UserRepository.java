package ru.home.preparado.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.home.preparado.model.User;

@Repository
interface UserRepository extends MongoRepository<User, String> {
}
