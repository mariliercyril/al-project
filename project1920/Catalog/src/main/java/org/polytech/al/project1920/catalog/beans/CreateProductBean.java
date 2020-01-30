package org.polytech.al.project1920.catalog.beans;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;
import org.polytech.al.project1920.catalog.services.CreateProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateProductBean {
    private final ProductStorageDB productStorageDB;

    @Autowired
    public CreateProductBean(ProductStorageDB productStorageDB) {
        this.productStorageDB = productStorageDB;
    }

    public void parseFile() throws IOException {
        List<String> lines = new ArrayList<>();

        ClassLoader classLoader = CreateProduct.class.getClassLoader();
        URL resource = classLoader.getResource("CreateProduct.txt");

        assert resource != null;
        File file = new File(resource.getFile());

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        Path newFilePath = Paths.get("src/main/resources/CreateProduct.txt");
        Files.deleteIfExists(newFilePath);
        Files.createFile(newFilePath);
    }
}
