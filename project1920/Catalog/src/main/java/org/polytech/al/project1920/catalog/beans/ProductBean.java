package org.polytech.al.project1920.catalog.beans;

import org.polytech.al.project1920.catalog.model.ProductStorage;
import org.polytech.al.project1920.catalog.model.ProductStorageDB;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class ProductBean {

	private final
	ProductStorageDB productStorageDB;

	@Autowired
	public ProductBean(ProductStorageDB productStorageDB) {

		this.productStorageDB = productStorageDB;
	}

	public boolean getInfos(String productId){

		ProductStorage p = new ProductStorage(productId);
		productStorageDB.save(p);

		System.out.println(productStorageDB.findAll().size());

		return true;
	}

}
