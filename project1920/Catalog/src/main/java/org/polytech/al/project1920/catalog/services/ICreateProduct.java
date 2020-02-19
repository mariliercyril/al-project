package org.polytech.al.project1920.catalog.services;

import org.polytech.al.project1920.catalog.model.ProductStorage;

import java.io.IOException;
import java.util.List;

public interface ICreateProduct {
    void saveProducts(String request) throws IOException;
    String getProducts();
}
