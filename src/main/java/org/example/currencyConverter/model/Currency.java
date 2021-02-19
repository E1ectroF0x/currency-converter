package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Currency {

    // TODO: learn about generation types

    @JsonProperty("Cur_ID")
    @Id
    private Long id;

    @JsonProperty("Cur_Name_Eng")
    private String name;

    @JsonProperty("Cur_Abbreviation")
    private String abbreviation;

    @JsonProperty("Cur_DateStart")
    private Date date_start;

    @JsonProperty("Cur_DateEnd")
    private Date date_end;

}
