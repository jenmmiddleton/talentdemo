package com.frudence.talentdemo.controller;

import com.frudence.talentdemo.model.Product;
import com.frudence.talentdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyRetailController {

    @Autowired
    ProductService productService;

    public Product getProduct (Integer id) {
        return productService.getProduct(id);
    }
}
