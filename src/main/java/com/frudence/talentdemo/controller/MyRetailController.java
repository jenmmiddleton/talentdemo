package com.frudence.talentdemo.controller;

import com.frudence.talentdemo.model.Product;

public class MyRetailController {

    public Product getProduct (Integer id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
