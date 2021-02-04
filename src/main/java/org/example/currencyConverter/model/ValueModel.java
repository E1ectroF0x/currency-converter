package org.example.currencyConverter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ValueModel {

    @JsonProperty("value")
    Double value;

}
