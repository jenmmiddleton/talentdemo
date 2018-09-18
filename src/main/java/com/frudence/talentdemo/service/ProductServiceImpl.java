package com.frudence.talentdemo.service;

import com.frudence.talentdemo.feign.RedSky;
import com.frudence.talentdemo.model.Price;
import com.frudence.talentdemo.model.Product;
import com.frudence.talentdemo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private RedSky redSky;

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public Product getProduct(Integer id) {
        Product product = new Product();
        product.setId(id);

        try {
            String title = redSky.getTitle(id);
            product.setName(title);
        } catch (Exception e) {
            // Don't do anything
        }

        Optional<Price> price = priceRepository.findById(id);
        if (price.isPresent()) {
            product.setCurrentPrice(price.get());
        }
        return product;
    }
}