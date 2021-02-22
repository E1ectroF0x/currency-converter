package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

// TODO: add table for rates
// rework rateService to work with DB

@Entity
@Data
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rate_id;

    @JsonProperty("Cur_Scale")
    private Double rate_scale;

    @JsonProperty("Cur_Name")
    private String name;

    @JsonProperty("Date")
    private Date date;

    @JsonProperty("Cur_OfficialRate")
    private double official_rate;

    @JsonProperty("Cur_Id")
    private String currency_id;

}
