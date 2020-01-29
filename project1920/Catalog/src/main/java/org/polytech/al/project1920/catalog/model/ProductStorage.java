package org.polytech.al.project1920.catalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductStorageDB")
public class ProductStorage {

    @Id
    private String id;
    private String productID;

    private String name;
    private int minimalAge;
    private int maximalAge;
    private int minimalAmount;
    private int maximalAmount;
    private int price;

    public ProductStorage() {
    }

    public ProductStorage(String productID) {
        this.productID = productID;
    }

    public ProductStorage(String productID, String name, int price) {
        super();
        this.name = name;
        this.price = price;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public void setMinimalAge(int minimalAge) {
        this.minimalAge = minimalAge;
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

    public int getMaximalAge() {
        return maximalAge;
    }

    public void setMaximalAge(int maximalAge) {
        this.maximalAge = maximalAge;
    }

    public int getMinimalAmount() {
        return minimalAmount;
    }

    public void setMinimalAmount(int minimalAmount) {
        this.minimalAmount = minimalAmount;
    }

    public int getMaximalAmount() {
        return maximalAmount;
    }

    public void setMaximalAmount(int maximalAmount) {
        this.maximalAmount = maximalAmount;
    }
}
