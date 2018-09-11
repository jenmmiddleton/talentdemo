package com.frudence.talentdemo.controller;

import com.frudence.talentdemo.model.Product;
import com.frudence.talentdemo.service.MyRetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MyRetailController {

    @Autowired
    MyRetailService myRetailService;

    public Product getProduct (Integer id) {
        return myRetailService.getProduct(id);
    }
}
