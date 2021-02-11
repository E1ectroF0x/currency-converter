package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class Rate {
    @JsonProperty("Cur_ID")
    private Long id;

    @JsonProperty("Cur_Abbreviation")
    private String abbreviation;

    @JsonProperty("Cur_Scale")
    private Double value;

    @JsonProperty("Cur_Name")
    private String name;

    @JsonProperty("Date")
    private Date date;

    @JsonProperty("Cur_OfficialRate")
    private double officialRate;

}
