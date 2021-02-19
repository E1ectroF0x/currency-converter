package org.example.currencyConverter.service.impl;


import lombok.extern.slf4j.Slf4j;
import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.repository.CurrencyRepository;
import org.example.currencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.*;
import java.util.stream.Collectors;

@Component
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Value("https://www.nbrb.by/api/exrates")
    private String apiLink;

    @Override
    public void uploadCurrencies() {
        currencyRepository.deleteAll();
        List<Currency> currencyList;
        RestTemplate restTemplate = new RestTemplate();
        Currency[] currencies = restTemplate.getForObject("https://www.nbrb.by/api/exrates/currencies", Currency[].class);
        currencyList = currencies == null ? Collections.emptyList() : Arrays.asList(currencies);
        Date dateNow = new Date();
        currencyList = currencyList.stream()
                .filter(currency -> currency.getDate_end().getTime() > dateNow.getTime())
                .collect(Collectors.toList());



        currencyRepository.saveAll(currencyList);
    }

    @Override
    public List<Currency> getAllCurrencies() {
        return (List<Currency>) currencyRepository.findAll();
    }

    @Override
    public Currency getCurrencyByAbbreviation(String abbreviation) {
        List<Currency> currencyList = (List<Currency>) currencyRepository.findAll();
        return currencyList.stream()
                .filter(currency -> currency.getAbbreviation().equals(abbreviation))
                .findFirst()
                .orElse(new Currency());
    }
}
