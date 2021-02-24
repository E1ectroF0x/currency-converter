package org.example.currencyConverter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OutputModel {

    @JsonProperty("value")
    Double value;

   public OutputModel(Double value){

        this.value = value;

    };
}

