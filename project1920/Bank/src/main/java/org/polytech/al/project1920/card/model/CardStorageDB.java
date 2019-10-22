package org.polytech.al.project1920.card.model;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface CardStorageDB extends MongoRepository<CardStorage, String> {
	
	public Optional<CardStorage> getCardStorageById(String productId);

}
