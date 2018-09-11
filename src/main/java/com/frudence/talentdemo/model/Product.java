package com.frudence.talentdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Product {
    Integer id;

    String name;

    @JsonProperty("current_price")
    Price currentPrice;
}
