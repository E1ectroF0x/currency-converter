package org.example.currencyConverter.service;

import org.example.currencyConverter.model.Currency;

import java.util.List;

public interface CurrencyService {
    //Currency getCurrency();
    //List<Currency> getCurrencyList();
    //List<Currency> getSortedCurrencies(double value);

    List<Currency> getAllCurrencies();
    Currency getCurrencyByAbbreviation(String Abbreviation);

}

