package org.example.currencyConverter.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.service.RateService;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.example.currencyConverter.model.Rate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j

public class RateServiceImpl implements RateService {
    private List<Rate> rateList;

    public RateServiceImpl(){
        rateList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Rate[] rates = restTemplate.getForObject("https://www.nbrb.by/api/exrates/rates?periodicity=0", Rate[].class);
        rateList = rates == null ? Collections.emptyList() : Arrays.asList(rates);

    }
    @Override
    public Rate getRateByAbbreviation(String value){
        return rateList.stream().filter(rate -> rate.getAbbreviation().equalsIgnoreCase(value))
                .findFirst()
                .orElse(new Rate());
    }
    @Override
    public Rate getRateByID(String value){
        return rateList.stream().filter(rate -> rate.getId().toString().equals(value)).findFirst()
                .orElse(new Rate());
    }
    @Override
    public List<Rate> getAllRates() {
        return rateList;
    }

}
