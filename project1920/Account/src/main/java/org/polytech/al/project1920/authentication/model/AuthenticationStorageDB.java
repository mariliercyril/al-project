package org.polytech.al.project1920.authentication.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationStorageDB extends MongoRepository<AuthenticationStorage, String> {
    Optional<AuthenticationStorage> findAuthenticationStorageByUserId(String userId);
}
