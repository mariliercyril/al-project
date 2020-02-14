package org.polytech.al.project1920.catalog.services;

import org.polytech.al.project1920.catalog.model.ProductStorage;

import java.util.List;

public interface IRetrieveProducts {

    List<ProductStorage> retrieveProducts();
    String prettyDump();

}
