package org.polytech.al.project1920.bankaccount.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountStorageDB extends MongoRepository<BankAccountStorage, String> {
    List<BankAccountStorage> getBankAccountStoragesByUserID(String userId);
}
