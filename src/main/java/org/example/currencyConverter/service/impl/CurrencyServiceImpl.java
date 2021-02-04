package org.example.currencyConverter.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.service.CurrencyService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Component
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {

    private List<Currency> currencyList;

    public CurrencyServiceImpl(){
        currencyList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Currency[] currencies = restTemplate.getForObject("https://www.nbrb.by/api/exrates/currencies", Currency[].class);
        currencyList = currencies == null ? Collections.emptyList() : Arrays.asList(currencies);
        Date dateNow = new Date();
        currencyList = currencyList.stream()
                .filter(currency -> currency.getDateEnd().getTime() > dateNow.getTime())
                .collect(Collectors.toList());
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return currencyList;
    }

    @Override
    public Currency getCurrencyByAbbreviation(String abbreviation) {
        return currencyList.stream()
                .filter(currency -> currency.getAbbreviation().equals(abbreviation))
                .findFirst()
                .orElse(new Currency());
    }


    /*
    private List<Currency> currencyList;

    public CurrencyServiceImpl() {
        currencyList = new ArrayList<>();

        Currency currency1 = new Currency();
        currency1.setUuid(UUID.randomUUID());
        currency1.setName("DNUB");
        currency1.setValue(2.0);

        Currency currency2 = new Currency();
        currency2.setUuid(UUID.randomUUID());
        currency2.setName("NUB");
        currency2.setValue(3.0);

        currencyList.add(currency1);
        currencyList.add(currency2);
    }



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
        return currencyList;
    }

    @Override
    public List<Currency> getSortedCurrencies(double value) {
       return currencyList.stream()
               .filter(currency -> currency.getValue() >= value)
               .collect(Collectors.toList());
    }
     */
}
