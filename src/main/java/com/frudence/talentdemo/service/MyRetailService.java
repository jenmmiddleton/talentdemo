package com.frudence.talentdemo.service;

import com.frudence.talentdemo.model.Product;
import org.springframework.stereotype.Service;

@Service
public interface MyRetailService {

    Product getProduct(Integer id);
}
