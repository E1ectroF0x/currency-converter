package org.example.currencyConverter.service.impl;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.Rate;
import org.example.currencyConverter.repository.CurrencyRepository;
import org.example.currencyConverter.repository.RateRepository;
import org.example.currencyConverter.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UpdateServiceImpl implements UpdateService
{
    private RateRepository rateRepository;
    private RestTemplate restTemplate;
    private CurrencyRepository currencyRepository;

    public UpdateServiceImpl(CurrencyRepository currencyRepository, RateRepository rateRepository) {
        this.rateRepository = rateRepository;
        this.currencyRepository = currencyRepository;
        restTemplate = new RestTemplate();
    }
    @Override
    public void updateAll() {
        rateRepository.deleteAll();
        List<Rate> rateList;
        rateList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Rate[] rates = restTemplate.getForObject("https://www.nbrb.by/api/exrates/rates?periodicity=0", Rate[].class);
        rateList = rates == null ? Collections.emptyList() : Arrays.asList(rates);
        rateRepository.saveAll(rateList);
        currencyRepository.deleteAll();
        List<Currency> currencyList;
        Currency[] currencies = restTemplate.getForObject("https://www.nbrb.by/api/exrates/currencies", Currency[].class);
        currencyList = currencies == null ? Collections.emptyList() : Arrays.asList(currencies);
        Date dateNow = new Date();
        currencyList = currencyList.stream()
                .filter(currency -> currency.getDate_end().getTime() > dateNow.getTime())
                .collect(Collectors.toList());
        currencyRepository.saveAll(currencyList);
    }
}
