package org.polytech.al.project1920.catalog.services;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManagerCatalogService implements IAddItem, IRetrieveProducts {

    private final ProductStorageDB productStorageDB;

    @Autowired
    public ManagerCatalogService(ProductStorageDB productStorageDB) {

        this.productStorageDB = productStorageDB;
    }

    @Override
    @PostMapping(path = "/products", consumes = "application/json", produces = "application/json")
    public boolean addItem(@RequestBody ProductStorage product) {

        int productsNumber = (productStorageDB.findAll()).size();

        productStorageDB.save(product);

        return ((productsNumber + 1) == (productStorageDB.findAll()).size());
    }

    @Override
    @GetMapping(path = "/products", consumes = "application/json", produces = "application/json")
    public List<ProductStorage> retrieveProducts() {

        return productStorageDB.findAll();
    }

}
