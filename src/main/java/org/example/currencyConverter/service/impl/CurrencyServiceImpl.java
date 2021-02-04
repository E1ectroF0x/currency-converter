package org.example.currencyConverter.service.impl;


import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.service.CurrencyService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CurrencyServiceImpl implements CurrencyService {

    private List<Currency> currencyList;

    @Override
    public Currency getCurrency() {
        Currency currency = new Currency();
        currency.setUuid(UUID.randomUUID());
        currency.setName("BYND");
        currency.setValue(1.0);
        return currency;
    }

    @Override
    public List<Currency> getCurrencyList() {
       currencyList = new ArrayList<>();
       Currency currency1 = new Currency();
       currency1.setUuid(UUID.randomUUID());
       currency1.setName("DNUB");
       currency1.setValue(2.0);
       currencyList.add(currency1);
       Currency currency2 = new Currency();
       currency2.setUuid(UUID.randomUUID());
       currency2.setName("NUB");
       currency2.setValue(3.0);
       currencyList.add(currency2);
        return currencyList;

    }






}
