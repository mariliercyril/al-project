package org.polytech.al.project1920.catalog.services;

import org.polytech.al.project1920.catalog.beans.ProductBean;
import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreateProduct implements ICreateProduct {
    private final ProductBean productBean;

    @Autowired
    public CreateProduct(ProductBean productBean) {
        this.productBean = productBean;
    }

    @Override
    @RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
    public void saveProducts(@RequestParam String request) {
        productBean.saveProducts(request);
    }

    @Override
    @RequestMapping(value = "/getProducts", method = RequestMethod.GET)
    public String getProducts() {
        return productBean.getProducts();
    }
}
