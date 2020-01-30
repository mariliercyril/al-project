package org.polytech.al.project1920.catalog.services;

import org.polytech.al.project1920.catalog.beans.CreateProductBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Component
public class CreateProduct implements ICreateProduct {
    private final CreateProductBean createProductBean;

    @Autowired
    public CreateProduct(CreateProductBean createProductBean) {
        this.createProductBean = createProductBean;
    }

    @Override
    @RequestMapping(value = "/saveProducts", method = RequestMethod.POST)
    public void saveProducts() throws IOException {
        createProductBean.parseFile();
    }
}
