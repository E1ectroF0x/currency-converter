package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Currency {

    // TODO: learn about generation types

    @JsonProperty("Cur_ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("Cur_Scale")
    private Double value;

    @JsonProperty("Cur_Name_Eng")
    private String name;

    @JsonProperty("Cur_Abbreviation")
    private String abbreviation;

    @JsonProperty("Cur_DateStart")
    private Date date_start;

    @JsonProperty("Cur_DateEnd")
    private Date date_end;

}
