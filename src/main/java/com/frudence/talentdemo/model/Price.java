package com.frudence.talentdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Price {
    Integer id;

    Double value;

    @JsonProperty("currency_code")
    String currencyCode;
}
