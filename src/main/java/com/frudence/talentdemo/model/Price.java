package com.frudence.talentdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {
    @JsonIgnore
    Integer id;

    Double value;

    @JsonProperty("currency_code")
    String currencyCode;
}
