package org.polytech.al.project1920.catalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductStorageDB")
public class ProductStorage {

    @Id
    private String id;
    private String productID;

    private String name;
    private int price;

    public ProductStorage(String productID) {

        this.productID = productID;
    }

    public ProductStorage(String productID, String name, int price) {

        super();

        this.name = name;
        this.price = price;
    }

    public String getId() {

        return id;
    }

    public String getProductID() {

        return productID;
    }

    public void setProductID(String productID) {

        this.productID = productID;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

}
