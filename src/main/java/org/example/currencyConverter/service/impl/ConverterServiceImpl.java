package org.example.currencyConverter.service.impl;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.model.InputModel;
import org.example.currencyConverter.model.OutputModel;
import org.example.currencyConverter.model.Rate;
import org.example.currencyConverter.repository.CurrencyRepository;
import org.example.currencyConverter.repository.RateRepository;
import org.example.currencyConverter.service.ConverterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.function.ToLongFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ConverterServiceImpl implements ConverterService {

    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private RateRepository rateRepository;

    List<Currency> currencyList = (List<Currency>) currencyRepository.findAll();
    List<Rate> rateList = (List<Rate>) rateRepository.findAll();

    @Override
    public OutputModel convert(InputModel inputModel) {

        return new OutputModel(inputModel.getValue()*getRates(inputModel));


    }

    public double getRates(InputModel inputModel){

        Long sourceCurId = currencyList.stream()
                .filter(currency -> currency.getAbbreviation().equals(inputModel.getSourceCur()))
                .map(currency -> currency.getId()).findFirst().orElse(null);

        return rateList.stream().filter(rate -> rate.getCurrency_id().equals(sourceCurId))
                .map(rate -> rate.getOfficial_rate()/rate.getRate_scale()).findFirst().orElse(null);


    }




}
