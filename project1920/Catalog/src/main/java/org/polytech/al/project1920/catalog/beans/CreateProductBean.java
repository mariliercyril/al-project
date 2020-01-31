package org.polytech.al.project1920.catalog.beans;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductBean {
    private final ProductStorageDB productStorageDB;

    @Autowired
    public CreateProductBean(ProductStorageDB productStorageDB) {
        this.productStorageDB = productStorageDB;
    }

    public void parseFile(String request) {
        String[] lines = request.split("\n");

        for (String line : lines) {
            ProductStorage productStorage = new ProductStorage();
            String[] splittedLine = line.split("\\s+");
            String name = splittedLine[2];
            String condition = splittedLine[5];
            String operator = splittedLine[6];
            int value = Integer.parseInt(splittedLine[7]);

            productStorage.setProduct(name);
            productStorage.setCondition(condition);
            productStorage.setOperator(operator);
            productStorage.setValue(value);
            productStorageDB.save(productStorage);
        }
    }
}
