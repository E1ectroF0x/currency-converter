package org.example.currencyConverter.model;



import lombok.Data;

import java.util.UUID;

@Data
public class Currency {

    private UUID uuid;
    private double value;
    private String name;

}
