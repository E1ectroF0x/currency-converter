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

    @JsonProperty("Cur_ID")
    @Id
    private Long id;

    @JsonProperty("Cur_Scale")
    private Double scale;

    @JsonProperty("Cur_Name")
    private String name;

    @JsonProperty("Date")
    private Date date;

    @JsonProperty("Cur_OfficialRate")
    private double officialRate;

    @OneToOne
    @JoinColumn(name = "currency", referencedColumnName = "id")
    private Currency currency;

}
