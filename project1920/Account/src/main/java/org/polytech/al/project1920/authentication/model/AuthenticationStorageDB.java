package org.polytech.al.project1920.authentication.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationStorageDB extends MongoRepository<AuthenticationStorage, String> {
}
