package org.example.currencyConverter.controller;

import org.example.currencyConverter.model.Currency;
import org.example.currencyConverter.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping
    public Currency getCurrency() {
        return currencyService.getCurrency();
    }

    @GetMapping("/all")
    public List<Currency> getCurrencyList() {
        return currencyService.getCurrencyList();
    }

}
