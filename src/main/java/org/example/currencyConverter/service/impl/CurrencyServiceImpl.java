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

    @Value("${nbrb.api.link}")
    private String apiLink;


    public CurrencyServiceImpl(){
        this.uploadCurrencies();
    }

    private void uploadCurrencies() {
        List<Currency> currencyList;
        RestTemplate restTemplate = new RestTemplate();
        Currency[] currencies = restTemplate.getForObject(apiLink + "/currencies", Currency[].class);
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

    @Override
    public void saveValue() {
        Currency currency1 = new Currency();
        currency1.setName("DNUB");
        currency1.setValue(2.0);
        currencyRepository.save(currency1);
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
