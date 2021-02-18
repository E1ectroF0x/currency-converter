package org.example.currencyConverter.service.impl;

import lombok.extern.slf4j.Slf4j;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.repository.RateRepository;
import org.example.currencyConverter.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.example.currencyConverter.model.Rate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class RateServiceImpl implements RateService {
    @Autowired
    private RateRepository rateRepository;

    @Value("https://www.nbrb.by/api/exrates")
    private String apiLink;

    private List<Rate> rateList;

    public RateServiceImpl(){this.uploadRates();}

    private void uploadRates(){
        rateList = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        Rate[] rates = restTemplate.getForObject("https://www.nbrb.by/api/exrates/rates?periodicity=0", Rate[].class);
        rateList = rates == null ? Collections.emptyList() : Arrays.asList(rates);
        rateRepository.saveAll(rateList);
    }

    @Override
    public Rate getRateByAbbreviation(String value){
        return rateList.stream().filter(rate -> rate.getAbbreviation().equals(value))
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
