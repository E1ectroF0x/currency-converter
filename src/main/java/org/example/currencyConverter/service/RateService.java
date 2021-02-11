package org.example.currencyConverter.service;

import org.example.currencyConverter.model.Rate;

public interface RateService {
    Rate getRateByAbbreviation(String value);
    Rate getRateByID(String value);
}
