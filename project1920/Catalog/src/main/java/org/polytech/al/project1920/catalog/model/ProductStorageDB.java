package org.polytech.al.project1920.catalog.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStorageDB extends MongoRepository<ProductStorage, String> {

    public Optional<ProductStorage> getProductStorageById(String productId);

}
