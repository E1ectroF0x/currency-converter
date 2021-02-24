package org.example.currencyConverter.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InputModel {

    @JsonProperty("sourceCur")
    private String sourceCur;

    @JsonProperty("targetCur")
    private String targetCur;

    @JsonProperty("value")
    private Double value;


}
