package org.example.currencyConverter.model;



import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.example.currencyConverter.service.CurrencyService;
import org.example.currencyConverter.service.impl.CurrencyServiceImpl;

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

    @JsonProperty("Date")
    private Date rate_date;

    @JsonProperty("Cur_OfficialRate")
    private Double official_rate;

    @JsonProperty("Cur_ID")
    private Long currency_id;

}
