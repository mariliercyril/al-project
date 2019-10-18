package org.polytech.al.project1920.bankaccount.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankAccountStorageDB extends MongoRepository<BankAccountStorage, String> {
    public Optional<BankAccountStorage> getBankAccountStorageById(String id);
}
