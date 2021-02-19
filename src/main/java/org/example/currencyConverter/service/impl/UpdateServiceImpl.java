package org.example.currencyConverter.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.Rate;
import org.example.currencyConverter.model.RateModel;
import org.example.currencyConverter.repository.CurrencyRepository;
import org.example.currencyConverter.repository.RateRepository;
import org.example.currencyConverter.service.UpdateService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UpdateServiceImpl implements UpdateService {

    private RestTemplate restTemplate;
    private CurrencyRepository currencyRepository;
    private RateRepository rateRepository;

    public UpdateServiceImpl(CurrencyRepository currencyRepository,
                             RateRepository rateRepository) {
        this.currencyRepository = currencyRepository;
        this.rateRepository = rateRepository;
        restTemplate = new RestTemplate();
    }

    @Value("${nbrb.api.link}")
    private String apiLink;

    @Override
    public void updateAllValues() {
        currencyRepository.deleteAll();
        rateRepository.deleteAll();

        List<Currency> currencies = retrieveCurrencies();
        currencies = filterCurrenciesByActive(currencies);
        currencyRepository.saveAll(currencies);

        List<Rate> rates = retrieveRates().stream()
                .map(this::mapRateModelToRateEntity)
                .collect(Collectors.toList());

        rateRepository.saveAll(rates);

    }

    private List<Currency> retrieveCurrencies() {
        Currency[] curArray = restTemplate.getForObject(apiLink + "/currencies", Currency[].class);
        return curArray == null
                ? Collections.emptyList()
                : Arrays.asList(curArray);
    }

    private List<RateModel> retrieveRates() {
        RateModel[] rateArray = restTemplate.getForObject(apiLink + "/rates?periodicity=0", RateModel[].class);
        return rateArray == null
                ? Collections.emptyList()
                : Arrays.asList(rateArray);
    }

    private List<Currency> filterCurrenciesByActive(List<Currency> currencies) {
        Date dateNow = new Date();
        return currencies.stream()
                .filter(currency -> currency.getDate_end().getTime() > dateNow.getTime())
                .collect(Collectors.toList());
    }

    private Currency getCurrencyByCurId(Long curId) {
        return currencyRepository.findById(curId).orElse(null);
    }

    private Rate mapRateModelToRateEntity(RateModel model) {
        Rate rate = new Rate();
        rate.setName(model.getName());
        rate.setScale(model.getScale());
        rate.setDate(model.getDate());
        rate.setOfficial_rate(model.getOfficial_rate());
        rate.setCurrency(getCurrencyByCurId(model.getCurrency_id()));
        return rate;
    }

}
