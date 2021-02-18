package org.example.currencyConverter.service;

import org.example.currencyConverter.model.Currency;

import java.util.List;

public interface CurrencyService {

    List<Currency> getAllCurrencies();
    Currency getCurrencyByAbbreviation(String Abbreviation);
    void uploadCurrencies();

}

