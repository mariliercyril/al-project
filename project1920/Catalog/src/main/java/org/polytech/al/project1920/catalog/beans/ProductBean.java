package org.polytech.al.project1920.catalog.beans;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductBean {
    private final ProductStorageDB productStorageDB;

    @Autowired
    public ProductBean(ProductStorageDB productStorageDB) {
        this.productStorageDB = productStorageDB;
    }

    public void saveProducts(String request) {
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

    public void prettyDump() {
        List<ProductStorage> productStorages = productStorageDB.findAll();

        System.out.println("\n------ PRODUCTS PRETTY DUMP ------");
        System.out.println("Here is the list of products : \n");
        for (ProductStorage productStorage : productStorages) {
            System.out.println("Product name : " + productStorage.getProduct());
            System.out.println("Condition : " + productStorage.getCondition() + " " + productStorage.getOperator() + " " + productStorage.getValue());
            System.out.println();
        }

        System.out.println("\n------ END OF PRODUCTS PRETTY DUMP ------\n");
    }
}
