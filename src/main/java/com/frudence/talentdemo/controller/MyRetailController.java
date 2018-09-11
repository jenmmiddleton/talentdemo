package com.frudence.talentdemo.controller;

import com.frudence.talentdemo.model.Product;
import com.frudence.talentdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class MyRetailController {

    @Autowired
    ProductService productService;

    @GetMapping(value="/{id}")
    public Product getProduct (@PathVariable Integer id) {
        return productService.getProduct(id);
    }
}
