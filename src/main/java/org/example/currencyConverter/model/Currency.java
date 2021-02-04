package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Currency {

    @JsonProperty("Cur_ID")
    private Long id;

    @JsonProperty("Cur_Scale")
    private Double value;

    @JsonProperty("Cur_Name_Eng")
    private String name;

    @JsonProperty("Cur_Abbreviation")
    private String abbreviation;

    @JsonProperty("Cur_DateStart")
    private Date dateStart;

    @JsonProperty("Cur_DateEnd")
    private Date dateEnd;

}
