package com.frudence.talentdemo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(Include.NON_EMPTY)
public class Product {
    Integer id;

    String name;

    @JsonProperty("current_price")
    Price currentPrice;
}
