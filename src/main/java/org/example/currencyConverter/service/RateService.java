package org.example.currencyConverter.service;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.Rate;

import java.util.List;

public interface RateService {
    List<Rate> getAllRates();
    Rate getRateByID(Long value);

}
