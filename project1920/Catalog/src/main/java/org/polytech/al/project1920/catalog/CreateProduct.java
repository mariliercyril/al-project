package org.polytech.al.project1920.catalog;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProduct {
    private final ProductStorageDB productStorageDB;
    private ProductStorage productStorage = new ProductStorage();

    @Autowired
    public CreateProduct(ProductStorageDB productStorageDB) {
        this.productStorageDB = productStorageDB;
    }

    public ProductStorage withPrice(int price) {
        this.productStorage.setPrice(price);
        return this.productStorage;
    }

    public ProductStorage withName(String name) {
        this.productStorage.setName(name);
        return this.productStorage;
    }

    public ProductStorage withMinimalAge(int minimalAge) {
        this.productStorage.setMinimalAge(minimalAge);
        return this.productStorage;
    }

    public ProductStorage withMaximalAge(int maximalAge) {
        this.productStorage.setMaximalAge(maximalAge);
        return this.productStorage;
    }

    public ProductStorage withMinimalAmount(int amount) {
        this.productStorage.setMinimalAmount(amount);
        return this.productStorage;
    }

    public ProductStorage withMaximalAmount(int amount) {
        this.productStorage.setMaximalAmount(amount);
        return this.productStorage;
    }

    public void save() {
        productStorageDB.save(this.productStorage);
        this.productStorage = new ProductStorage();
    }
}
