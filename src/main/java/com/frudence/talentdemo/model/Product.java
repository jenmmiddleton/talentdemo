package com.frudence.talentdemo.model;

import lombok.Data;

@Data
public class Product {
    Integer id;

    String name;

    Price currentPrice;
}
