package org.polytech.al.project1920.useraccount.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDB extends MongoRepository<User, String> {
    Optional<User> findUserByUserId(String userId);
}
